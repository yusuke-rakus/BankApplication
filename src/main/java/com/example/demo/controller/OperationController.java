package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.domain.Bank;
import com.example.demo.domain.TransferColumn;
import com.example.demo.domain.User;
import com.example.demo.form.TransferForm;
import com.example.demo.service.BankService;
import com.example.demo.service.TransferService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/userPage")
public class OperationController {

	@Autowired
	private UserService userService;

	@Autowired
	private TransferService transferService;

	@Autowired
	private BankService bankService;

	@Autowired
	private HttpSession session;

	private String oneTimePass = null;

	@RequestMapping("")
	public String userPage() {
		return "user-view/home";
	}

	/** 振込ページへ遷移 */
	@RequestMapping("/transferPage")
	public String transferPage(Integer id, Model model, RedirectAttributes redirectAttributes) {

		/** 現在残高の表示 */
		User user = userService.findById(id);
		model.addAttribute("id", user.getId());
		model.addAttribute("lastName", user.getLastName());
		model.addAttribute("amount", user.getAmount());
		/** 銀行リストの表示 */
		List<Bank> bankList = bankService.findAll();
		model.addAttribute("bankList", bankList);
		return "user-view/transfer-view";
	}

	/** 振込処理 */
	@RequestMapping("/transfer")
	public String transfer(TransferForm form, Model model, RedirectAttributes redirect) {
		User withdrawalUser = userService.findById(form.getId());
		User depositUser = userService.findByBankNameAndAccount(form.getBankName(), form.getAcceptAccount());
		Integer transferAmount = form.getAmount();
		if (depositUser == null) {
			model.addAttribute("notFound", "notFound");
			model.addAttribute("selectedBankName", form.getBankName());
			model.addAttribute("acceptAccount", form.getAcceptAccount());
			model.addAttribute("requestAmount", form.getAmount());
			return "forward:/userPage/transferPage";
		}
		if (withdrawalUser.getAmount() - transferAmount < 0) {
			model.addAttribute("InsufficientAmount", "InsufficientAmount");
			model.addAttribute("selectedBankName", form.getBankName());
			model.addAttribute("acceptAccount", form.getAcceptAccount());
			model.addAttribute("requestAmount", form.getAmount());
			return "forward:/userPage/transferPage";
		}

		/** 二段階認証画面に出力する情報 */
		model.addAttribute("withdrawalUser", withdrawalUser);
		model.addAttribute("depositUser", depositUser);
		model.addAttribute("transferAmount", transferAmount);

		/** ワンタイムパスワードを生成しコンソールに出力 */
		StringBuilder pass = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			pass.insert(i, (int) (Math.random() * 10));
		}
		oneTimePass = pass.toString();
		System.out.println("以下のパスワードを画面に入力してください:");
		System.out.println(oneTimePass);

		/** 認証画面へ遷移 */
		return "/user-view/verification-view";
	}

	@RequestMapping("/verification")
	public String verification(String inputOneTimePass, Integer withdrawalUserId, Integer depositUserId,
			Integer transferAmount, Model model) {
		if (inputOneTimePass.equals(oneTimePass)) {
			User withdrawalUser = userService.findById(withdrawalUserId);
			User depositUser = userService.findById(depositUserId);
			userService.withdrawal(withdrawalUser, transferAmount);
			userService.deposit(depositUser, transferAmount);

			/** saveメソッドを呼び出してtransaction_listへ格納 */
			transferService.save(withdrawalUser, withdrawalUser.getAmount(), depositUser, depositUser.getAmount(),
					transferAmount);

			/** sessionの再設定 */
			List<TransferColumn> transferList = transferService.findTransferList(withdrawalUser.getAccountNumber());
			session.setAttribute("transferList", transferList);

			return "redirect:/userPage/";
		} else {
			model.addAttribute("error", "error");
			return "user-view/verification-view";
		}
	}

	@RequestMapping("/logout")
	public String logout() {
		/** セッション情報の削除 */
		session.invalidate();
		return "redirect:/";
	}

}

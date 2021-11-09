package com.example.demo.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.domain.Bank;
import com.example.demo.domain.TransferColumn;
import com.example.demo.domain.User;
import com.example.demo.form.LoginForm;
import com.example.demo.form.NewAccountForm;
import com.example.demo.service.BankService;
import com.example.demo.service.TransferService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private BankService bankService;
	@Autowired
	private UserService userService;
	
	@ModelAttribute
	NewAccountForm setNewAccountForm() {
		return new NewAccountForm();
	}
	@ModelAttribute
	LoginForm setLoginForm() {
		return new LoginForm();
	}
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private TransferService transferService;
	
	@RequestMapping("")
	public String loginView() {
		return "entry/login-view";
	}
	
	/** ログイン時の処理 */
	 @RequestMapping("/login")
	 public String login(LoginForm form, Model model, RedirectAttributes redirect) {
		 User user = userService.findByAccountAndPassword(form.getAccountNumber(), form.getPassword());
		 if(user == null) {
			 model.addAttribute("errorMessage", "errorMessage");
			 return "entry/login-view";
		 }
		 List<TransferColumn> transferList = transferService.findTransferList(user.getAccountNumber());
		 redirect.addFlashAttribute("transferList", transferList);
		 
		 session.setAttribute("id", user.getId());
		 session.setAttribute("lastName", user.getLastName());
		 session.setAttribute("bankName", user.getBankName());
		 session.setAttribute("accountNumber", user.getAccountNumber());
		 return "redirect:userPage/";
	 }
	
	/**
	 * 新規口座開設画面へ遷移
	 * @param model　年齢リスト, 銀行リスト
	 * @return 新規口座開設画面
	 */
	@RequestMapping("/makeAccountPage")
	public String makeAccountPage(Model model) {
		// 年齢リストの作成
		List<Integer> ageList = new LinkedList<>();
		for(int i=20; i<=60; i++) {
			ageList.add(i);
		}
		model.addAttribute("ageList", ageList);

		// 銀行リストの作成
		List<Bank> bankList = bankService.findAll();
		model.addAttribute("bankList", bankList);
		return "entry/make-account";
	}
	
	@RequestMapping("/createAccount")
	public String createAccount(NewAccountForm form) {
		User user = new User();
		BeanUtils.copyProperties(form, user);
		userService.insert(user);
		return "redirect:/";
	}

}

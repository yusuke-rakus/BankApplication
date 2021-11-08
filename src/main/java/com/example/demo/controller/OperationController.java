package com.example.demo.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping("")
	public String userPage() {
		return "user-view/home";
	}
	
	/** 振込ページへ遷移 */
	@RequestMapping("/transferPage")
	public String transferPage(Integer id, Model model) {
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
	
	@RequestMapping("/transfer")
	public String transfer(TransferForm form, Model model) {
		User withdrawalUser = userService.findById(form.getId());
		User depositUser = userService.findByBankNameAndAccount(form.getBankName(), form.getAcceptAccount());
		Integer transferAmount = form.getAmount();
		if(depositUser == null) {
			model.addAttribute("notFound", "notFound");
			model.addAttribute("selectedBankName", form.getBankName());
			model.addAttribute("acceptAccount", form.getAcceptAccount());
			model.addAttribute("requestAmount", form.getAmount());
			return "forward:/userPage/transferPage";
		}
		if(withdrawalUser.getAmount() - transferAmount < 0) {
			model.addAttribute("InsufficientAmount", "InsufficientAmount");
			model.addAttribute("selectedBankName", form.getBankName());
			model.addAttribute("acceptAccount", form.getAcceptAccount());
			model.addAttribute("requestAmount", form.getAmount());
			return "forward:/userPage/transferPage";
		}
		userService.withdrawal(withdrawalUser, transferAmount);
		userService.deposit(depositUser, transferAmount);
		
		/** saveメソッドを呼び出してtransaction_listへ格納 */
		transferService.save(withdrawalUser, depositUser, transferAmount);
		
		return "redirect:/userPage/";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}

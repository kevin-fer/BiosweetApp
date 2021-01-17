package com.example.ProductMarket;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

@RestController
public class AccountGestionService {

	//private List<Account> cars = new ArrayList<Account>();
	AccountRepository accountRepository;

	@Autowired
	public AccountGestionService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
		/*cars.add*/
		//Account account = new Account("11AA22", "Ferrari", 1000);
		//accountRepository.save(account);
		/*cars.add*/
		//account = new Account("33BB44", "Porshe", 2222);
		//accountRepository.save(account);
	}

	@GetMapping("/comptes")
	public List<Account> getListOfAccounts() {
		return accountRepository.findAll();  // <=> select * from Account
	}

	@PostMapping("/comptes")
	public void addAccount(@RequestBody Account account) throws Exception {
		System.out.println(account);
		accountRepository.save(account);
	}

	@GetMapping("/comptes/{adressmail}")
	public Account getAccount(@PathVariable(value = "adressmail") String adressmail) {
		for (Account account : accountRepository.findAll()) {
			if (account.getAdressMail().equals(adressmail)) {
				return account;
			}
		}
		return null;
	}

	@DeleteMapping("/comptes/{adressmail}")
	public void delCar(@PathVariable(value = "adressmail") String adressmail) {
		for (Account account : accountRepository.findAll()) {
			if (account.getAdressMail().equals(adressmail)) {
				//accountRepository.findAll().remove(account);
				accountRepository.delete(account);
			}
		}
	}

	@Transactional
	@PutMapping("/comptes/{adressmail}")
	public void rent(@PathVariable("adressmail") String adressmail, @RequestParam(value="rent",
			required = true)boolean rent, @RequestBody Date dates){
		for(Account account : accountRepository.findAll()){
			if(account.getAdressMail().equals(adressmail)){
				//account.setDates(dates);
				//account.setRented(rent);
				System.out.print(rent);
				Account c = accountRepository.findById(account.getAdressMail()).get();
				//c.setRented(rent);
			//	c.setDates(dates);
				System.out.print(c);

			}
		}
	}
/*
	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT)
	public void rent(@PathVariable("plateNumber") String plateNumber, @RequestParam(value = "rent", required = true) boolean rent, @RequestBody Date dates) {
		for (Account car : accountRepository.findAll()) {
			if (car.getPlateNumber().equals(plateNumber)) {
				car.setDates(dates.getBegin(), dates.getEnd());
			}
		}
	}


	@PutMapping(value = "/cars/{plateNumber}/back")
	public void getBackTheCar(@PathVariable("plateNumber") String plateNumber, @RequestParam(value = "rent", required = false) boolean rent) {
		for (Account car : accountRepository.findAll()) { //cars le tablo
			if (car.getPlateNumber().equals(plateNumber)) {
				car.getDateLocation().remove(car.getDateLocation().size()-1);
				// car[i].getLocation
			}
		}
	}
*/

	/*@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT)
	public void rent(@PathVariable("plateNumber") String plateNumber, @RequestParam(value = "rent", required = true) boolean rent, @RequestBody Date dates) {
		for (Account car : cars) {
			if (car.getPlateNumber().equals(plateNumber)) {
				if(rent==true){
					car.setDates(dates.getBegin(), dates.getEnd());
				} else {
					car.getDateLocation().remove(car.getDateLocation().size()-1);
				}
			}
		}
	}*/
}



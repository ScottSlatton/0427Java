package com.hackbank.business.services.transfer;

import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.hackbank.business.exceptions.BusinessException;
import com.hackbank.business.services.account.AccountService;
import com.hackbank.business.services.account.AccountServiceImpl;
import com.hackbank.business.validations.Validation;
import com.hackbank.persistence.dao.account.AccountDAO;
import com.hackbank.persistence.dao.account.AccountDAOImpl;
import com.hackbank.persistence.dao.transfer.TransferDAO;
import com.hackbank.persistence.dao.transfer.TransferDAOImpl;
import com.hackbank.persistence.models.Account;
import com.hackbank.persistence.models.Transfer;

public class TransferServiceImpl implements TransferService{
	
	final static Logger loggy = Logger.getLogger(TransferDAOImpl.class);
	final static Validation valid = new Validation();
	final static TransferDAO transferDAO = new TransferDAOImpl();
	final static AccountDAO accountDAO = new AccountDAOImpl();
	final static AccountService accountSrv = new AccountServiceImpl();
	
	public static void main(String[] args) {
		loggy.setLevel(Level.INFO);
	}
	
	@Override
	public boolean createTransfer(Transfer transfer, Account account) throws BusinessException {
		boolean flag = false;
		if (transfer == null) {
			throw new BusinessException("Object Error, please contact SYSADMIN\n");
		}else if(!valid.isValidAccountNumber(transfer.getIniAcccountNumber())){
			throw new BusinessException("Initial Account number "+transfer.getIniAcccountNumber()+" is not valid.\n");
		}else if(!valid.isValidAccountNumber(transfer.getEndAccountNumber())){
			throw new BusinessException("End Account number "+transfer.getEndAccountNumber()+" is not valid.\n");
		}else if(!valid.isValidAccountNumber(transfer.getIniRoutingNumber())){
			throw new BusinessException("Initial Routing number "+transfer.getIniRoutingNumber()+" is not valid.\n");
		}else if(!valid.isValidAccountNumber(transfer.getEndRoutingNumber())){
			throw new BusinessException("End Routing number "+transfer.getEndRoutingNumber()+" is not valid.\n");
		}else {
			if (accountDAO.getAccountByIdAndRoutingNumber(transfer.getEndAccountNumber(), transfer.getEndRoutingNumber()))
				flag = transferDAO.createTransfer(transfer);
			else {
				throw new BusinessException("End Account number "+transfer.getEndAccountNumber()+" is not valid.\n");
			}
		}
		return flag;
	}

	@Override
	public boolean acceptTransfer(Transfer transfer, Account account) throws BusinessException {
		boolean flag = transferDAO.acceptTransfer(transfer);
		if (flag) {
			if(transfer.getStatus().equals("Accept")) {
				account = accountSrv.depositBalanceAccount(account, transfer.getAmount());
			}else {
				account = accountSrv.depositBalanceAccount(account, transfer.getAmount());
			}
		}
		return flag;
	}

	@Override
	public List<Transfer> transferList(String id) throws BusinessException {
		return  transferDAO.transferList(id);
	}

	
	
}

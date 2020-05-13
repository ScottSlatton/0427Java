package com.hackbank.persistence.dao.transfer;

import java.util.List;

import com.hackbank.business.exceptions.BusinessException;
import com.hackbank.persistence.models.Transfer;

public interface TransferDAO {
	
	public abstract boolean createTransfer(Transfer transfer) throws BusinessException;
	public abstract List<Transfer> transferList(String id) throws BusinessException;
	public abstract boolean acceptTransfer(Transfer transfer) throws BusinessException;

}

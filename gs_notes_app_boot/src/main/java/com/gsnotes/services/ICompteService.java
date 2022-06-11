package com.gsnotes.services;

import java.util.List;

import com.gsnotes.bo.Compte;
import com.gsnotes.bo.Role;
import com.gsnotes.utils.export.FileManagerHelper;


public interface ICompteService {
	
	public List<Role> getAllRoles();
	
	public List<Compte> getAllAccounts();

	
	public Compte getAccountByUserName(String login);
	
	public String createUser(Long idRole, Long idPerson);
	
	public FileManagerHelper.ExcelExporter prepareCompteExport(List<Compte> comptes) ;
}

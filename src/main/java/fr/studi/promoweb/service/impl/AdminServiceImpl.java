package fr.studi.promoweb.service.impl;

import fr.studi.promoweb.pojo.Admin;
import fr.studi.promoweb.repository.AdminRepository;
import fr.studi.promoweb.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Admin> getAllAdmin(){
        return adminRepository.findAllAdmin();
    }

    @Override
    public Admin getAdminById(Long id){
        return adminRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteAdminById(Long id){
        adminRepository.deleteById(id);
    }

    @Override
    public void updateAdminById(Admin admin, Long id){
        Admin oldAdmin = getAdminById(id);

        if(oldAdmin != null){
            oldAdmin.setNom(admin.getNom());
            adminRepository.save(oldAdmin);
        }
    }

    @Override
    public void createAdmin(Admin admin){
        adminRepository.save(admin);
    }
}

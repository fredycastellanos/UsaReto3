package com.example.usareto3.Service;

import com.example.usareto3.Model.Admin;
import com.example.usareto3.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll(){
        return (List<Admin>) adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin admin){
        if(admin.getIdAdmin() == null){
            return adminRepository.save(admin);
        } else {
            Optional<Admin> adminEncontrado = adminRepository.getAdmin(admin.getIdAdmin());
            if (adminEncontrado.isEmpty()){
                return adminRepository.save(admin);
            } else {
                return admin;
            }
        }
    }

    public Admin update(Admin admin){
        if(admin.getIdAdmin() != null){
            Optional<Admin> adminEncontrado = adminRepository.getAdmin(admin.getIdAdmin());
            if(!adminEncontrado.isEmpty()){
                if(admin.getPassword() != null){
                    adminEncontrado.get().setPassword(admin.getPassword());
                }
                if(admin.getName() != null){
                    adminEncontrado.get().setName(admin.getName());
                }
                return adminRepository.save(adminEncontrado.get());
            }
        }
        return admin;
    }

    public boolean deleteAdmin(int adminId){
        Boolean resultado = getAdmin(adminId).map(adminPoreliminar ->{
            adminRepository.delete(adminPoreliminar);
            return true;
        }).orElse(false);
        return resultado;
    }
}

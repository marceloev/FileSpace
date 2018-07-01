package com.filespace;

import com.filespace.dao.UserDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@SpringBootApplication
public class FileSpaceApp {

	public static void main(String[] args) {
		SpringApplication.run(FileSpaceApp.class, args);
	}
}

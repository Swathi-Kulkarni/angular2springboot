package com.user.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.user.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public LoanTypeEnum validateUserEligibilityForLoan(User user) {
		Resource resource = new ClassPathResource("sample.txt");
		Collection<String> content = null;
		try {
			content = readLines(resource.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("the content of resources:" + content);
		return checkEligibility(content, user);
	}

	public static Collection<String> readLines(InputStream is) {
		List<String> out = new LinkedList<String>();
		BufferedReader r = new BufferedReader(new InputStreamReader(is));
		String line;
		try {
			while ((line = r.readLine()) != null) {
				out.add(line);
			}
		} catch (IOException e) {
			// throw new IOException("Problems reading from: " + is, e);
		}
		return out;
	}

	public LoanTypeEnum checkEligibility(Collection<String> content, User user) {
		for (String string : content) {
			String str[] = string.split("[-\\s]");
			int lowerLimitAge = Integer.valueOf(str[0]);
			int upperLimitAge = Integer.valueOf(str[1]);
			int lowerLimitSalary = Integer.valueOf(str[2]);
			int upperLimitSalary = Integer.valueOf(str[3]);
			if (user.getAge() <= upperLimitAge && user.getAge() >= lowerLimitAge
					&& user.getSalary() <= upperLimitSalary
					&& user.getSalary() >= lowerLimitSalary) {
				return LoanTypeEnum.Eligible;
			}else if(user.getAge() <= upperLimitAge && user.getAge() >= lowerLimitAge && user.getSalary()>upperLimitSalary){
				return LoanTypeEnum.Exceeds;
			}
		}
		return LoanTypeEnum.NotEligible;
	}

}

package com.user.service;

public enum LoanTypeEnum {
	Eligible("ELigible for the Loan"), NotEligible("Not Eligible For the Loan"),Exceeds("Exceeds the expected Salary");

	private String code;
	private String displayVal;

	private LoanTypeEnum(String code) {
		this.code = code;
	}
	
	private LoanTypeEnum(String code, String displayVal) {
		this.code = code;
		this.displayVal=displayVal;
	}

	public String getCode() {
		return code;
	}

	public boolean equalsCode(String code) {
		return this.code.equalsIgnoreCase(code);
	}

	public static LoanTypeEnum getByCode(String code) {
		for (LoanTypeEnum loanType : LoanTypeEnum.values()) {
			if (loanType.equalsCode(code)) {
				return loanType;
			}
		}
		return null;
	}

	public String getDisplayVal() {
		return displayVal;
	}

}

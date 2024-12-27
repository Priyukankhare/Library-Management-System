package org.techhub.Model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
	
	
	private String Uname;
	private int Uid;
	private String Uemail;
	private String Password;
	private int Uphone;
	private String Uaddress;
	private long AdharNo;
	private String gender;
	private List<Integer> bookIds; // List to store associated book IDs
	private Date borrowDate;
}


/*
 package org.techhub.Model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.*; // For validation annotations

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    @NotBlank(message = "Username cannot be blank")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String Uname;

    @Positive(message = "User ID must be a positive number")
    private int Uid;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email must be valid")
    private String Uemail;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
    private String Password;

    @NotNull(message = "Phone number cannot be null")
    @Digits(integer = 10, fraction = 0, message = "Phone number must be a 10-digit number")
    private int Uphone;

    @NotBlank(message = "Address cannot be blank")
    @Size(max = 255, message = "Address cannot exceed 255 characters")
    private String Uaddress;

    @NotNull(message = "Aadhar number cannot be null")
    @Digits(integer = 12, fraction = 0, message = "Aadhar number must be a 12-digit number")
    private long AdharNo;

    @NotBlank(message = "Gender cannot be blank")
    @Pattern(regexp = "Male|Female|Other", message = "Gender must be 'Male', 'Female', or 'Other'")
    private String gender;

    @NotNull(message = "Book IDs cannot be null")
    @Size(min = 1, message = "At least one book ID must be provided")
    private List<Integer> bookIds;

    @PastOrPresent(message = "Borrow date cannot be in the future")
    private Date borrowDate;
}

 */
	
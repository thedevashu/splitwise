//package com.splitwise.app.dto;
//
//import java.util.List;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.JoinTable;
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.ManyToOne;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//public class Expense {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long expenseId;
//	private Double amount;
//	
//	@ManyToOne
//	@JoinColumn(name="group_id")
//	private Group group;
//	@ManyToOne
//	@JoinColumn(name="payee_user_id")
//	private User payeeUserId;
//	
//	@ManyToMany
//	@JoinTable(
//			name="expense_participants",
//			joinColumns = @JoinColumn(name = "expense_id"),
//			inverseJoinColumns = @JoinColumn(name="user_id")
//			)
//	private List<User> participants;
//	private String description;
//
//}

package com.splitwise.app.dto;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseId;
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "payee_user_id")
    private Users payeeUser;  // Renamed for clarity and consistency with naming conventions

    @ManyToMany
    @JoinTable(
        name = "expense_participants",
        joinColumns = @JoinColumn(name = "expense_id"),  // Fixed the typo here
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<Users> participants;

    private String description;
}

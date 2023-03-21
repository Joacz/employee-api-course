package net.joagz.employees_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class Users {

  private String username;
  private String password;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Builder.Default
  private Boolean enabled = true;

  @Builder.Default
  private Boolean accountNonExpired = true;

  @Builder.Default
  private Boolean accountNonLocked = true;

  @Builder.Default
  private Boolean credentialsNonExpired = true;

  // Custom attributes
  private String email;
  private String creation_date;

  // Explain differences between LAZY and EAGER fetchType.
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "UserAuthorities", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "authority_id"))
  private List<Authorities> authorities;
}

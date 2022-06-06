package starter.pojo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    private String password;
    private RoleModel roleModel;
    private String lName;
    private String fName;
    private String name;
}

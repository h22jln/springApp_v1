package spring.myapp_v1.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class Board {
    private final String name;
    private final String content;
    private final String password;
    private final boolean ckPrivate = false;
}

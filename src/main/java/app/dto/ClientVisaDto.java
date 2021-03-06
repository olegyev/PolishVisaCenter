package app.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import lombok.ToString;
import org.springframework.hateoas.server.core.Relation;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Relation(itemRelation = "visa", collectionRelation = "visas")
public class ClientVisaDto extends ClientDto {

    private VisaDto visa;

}
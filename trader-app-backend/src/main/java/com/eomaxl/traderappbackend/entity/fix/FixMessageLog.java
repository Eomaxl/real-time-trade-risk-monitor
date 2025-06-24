package com.eomaxl.traderappbackend.entity.fix;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.w3c.dom.Text;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FixMessageLog {
    private Long id;
    private FixSession session;
    private DIRECTION direction;
    private String msgType;
    private Text rawMessage;
    private JSON parsedFields;
    private Timestamp timestamp;
}

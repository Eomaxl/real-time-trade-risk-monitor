package com.eomaxl.traderappbackend.entity.fix;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FixSession {
    private Long id;
    private String beginString;
    private String senderCompId;
    private String targetCompId;
    private FIX_STATUS status;
    private Timestamp lastHeartBeat;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}

enum FIX_STATUS {
    ACTIVE, INACTIVE, DISCONNECTED, CLOSED
}

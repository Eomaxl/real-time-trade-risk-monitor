package com.eomaxl.traderappbackend.entity.fix;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fix_sessions")
public class FixSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String beginString;
    private String senderCompId;
    private String targetCompId;

    @Enumerated(EnumType.STRING)
    private FixSessionStatus status;
    private Timestamp lastHeartBeat;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}

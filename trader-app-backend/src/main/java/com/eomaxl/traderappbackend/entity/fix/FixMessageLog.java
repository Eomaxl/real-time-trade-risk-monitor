package com.eomaxl.traderappbackend.entity.fix;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.w3c.dom.Text;

import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fix_message_logs")
public class FixMessageLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private FixSession session;

    @Enumerated(EnumType.STRING)
    private FixMsgDirection  direction;

    private String msgType;

    @Lob
    private String rawMessage;

    @Lob
    private String parsedFields;
    private Instant timestamp;
}

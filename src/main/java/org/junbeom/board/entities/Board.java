package org.junbeom.board.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junbeom.global.entities.BaseMemberEntity;

@Builder
@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Board extends BaseMemberEntity {
    @Id
    @Column(length = 30)
    private String bId;

    @Column(length = 60, nullable = false)
    private String bName;
}

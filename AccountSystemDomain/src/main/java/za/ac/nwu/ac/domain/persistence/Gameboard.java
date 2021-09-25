package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "GAMEBOARD", schema = "FATHIMA")
public class Gameboard implements Serializable {

    private static final long serialVersionUID = 7773910362304580082L;
    private Long gameboardId;
    private Long valueRevealed;

    public Gameboard(Long gameboardId, Long valueRevealed) {
        this.gameboardId = gameboardId;
        this.valueRevealed = valueRevealed;
    }

    public Gameboard() {
    }

    @Id
    @SequenceGenerator(name = "FATHI_GENERIC_SEQ", sequenceName = "FATHIMA.FATHI_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FATHI_GENERIC_SEQ")
    @Column(name = "Gameboard_ID")
    public Long getGameboardId() {
        return gameboardId;
    }

    public void setGameboardId(Long gameboardId) {
        this.gameboardId = gameboardId;
    }

    @Column(name = "Value_Revealed")
    public Long getValueRevealed() {
        return valueRevealed;
    }

    public void setValueRevealed(Long valueRevealed) {
        this.valueRevealed = valueRevealed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gameboard gameboard = (Gameboard) o;
        return Objects.equals(gameboardId, gameboard.gameboardId) && Objects.equals(valueRevealed, gameboard.valueRevealed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameboardId, valueRevealed);
    }

    @Override
    public String toString() {
        return "Gameboard{" +
                "gameboardId=" + gameboardId +
                ", valueRevealed=" + valueRevealed +
                '}';
    }
}

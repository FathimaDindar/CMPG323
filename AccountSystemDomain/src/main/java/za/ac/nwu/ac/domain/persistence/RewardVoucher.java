package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "REWARD_VOUCHER", schema = "FATHIMA")
public class RewardVoucher implements Serializable {

    private static final long serialVersionUID = -8879765375193052801L;
    private Long voucherId;
    private Long voucherValue;

    public RewardVoucher(Long voucherId, Long voucherValue) {
        this.voucherId = voucherId;
        this.voucherValue = voucherValue;
    }

    public RewardVoucher() {
    }

    @Id
    @SequenceGenerator(name = "FATHI_GENERIC_SEQ", sequenceName = "FATHIMA.FATHI_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FATHI_GENERIC_SEQ")
    @Column(name = "Voucher_ID")
    public Long getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Long voucherId) {
        this.voucherId = voucherId;
    }

    @Column(name = "Voucher_Value")
    public Long getVoucherValue() {
        return voucherValue;
    }

    public void setVoucherValue(Long voucherValue) {
        this.voucherValue = voucherValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RewardVoucher that = (RewardVoucher) o;
        return Objects.equals(voucherId, that.voucherId) && Objects.equals(voucherValue, that.voucherValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voucherId, voucherValue);
    }

    @Override
    public String toString() {
        return "RewardVoucher{" +
                "voucherId=" + voucherId +
                ", voucherValue=" + voucherValue +
                '}';
    }
}

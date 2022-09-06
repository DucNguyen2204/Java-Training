package employee_management;

import java.util.concurrent.ThreadLocalRandom;

public class Certificate {
    private long CertificateId;

    private String certificateName;

    private String certificateRank;

    private String certificateDate;

    public Certificate(String certificateName, String certificateRank, String certificateDate) {
        this.CertificateId = this.IdGenerator();
        this.certificateName = certificateName;
        this.certificateRank = certificateRank;
        this.certificateDate = certificateDate;
    }

    private Long IdGenerator() {
        return Math.abs(ThreadLocalRandom.current().nextLong(100000000));
    }

    public long getCertificateId() {
        return CertificateId;
    }

    public void setCertificateId(int certificateId) {
        CertificateId = certificateId;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificateRank() {
        return certificateRank;
    }

    public void setCertificateRank(String certificateRank) {
        this.certificateRank = certificateRank;
    }

    public String getCertificateDate() {
        return certificateDate;
    }

    public void setCertificateDate(String certificateDate) {
        this.certificateDate = certificateDate;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "CertificateId=" + CertificateId +
                ", certificateName='" + certificateName + '\'' +
                ", certificateRank=" + certificateRank +
                ", certificateDate='" + certificateDate + '\'' +
                '}';
    }
}

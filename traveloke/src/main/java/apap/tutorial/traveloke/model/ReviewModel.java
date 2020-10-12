package apap.tutorial.traveloke.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "review")
public class ReviewModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 10)
    @Column(name = "namaReviewer", nullable = false)
    private String namaReviewer;

    @NotNull
    @Size(max = 50)
    @Column(name = "isiReview", nullable = false)
    private String isiReview;

    @Size(max = 50)
    @Column(name = "saran", nullable = true)
    private String saran;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "nomorKamar", referencedColumnName = "noKamar", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private KamarModel kamar;

    @OneToMany(mappedBy = "kamar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ReviewModel> listReview;
}

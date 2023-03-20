package googledrive.domain;

import googledrive.VideoProcessingApplication;
import googledrive.domain.VideoPrecessed;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Video_table")
@Data
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long fileid;

    private String url;

    @PostPersist
    public void onPostPersist() {
        VideoPrecessed videoPrecessed = new VideoPrecessed(this);
        videoPrecessed.publishAfterCommit();
    }

    public static VideoRepository repository() {
        VideoRepository videoRepository = VideoProcessingApplication.applicationContext.getBean(
            VideoRepository.class
        );
        return videoRepository;
    }

    public static void processVideo(FileUploaded fileUploaded) {
        /** Example 1:  new item 
        Video video = new Video();
        repository().save(video);

        VideoPrecessed videoPrecessed = new VideoPrecessed(video);
        videoPrecessed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(fileUploaded.get???()).ifPresent(video->{
            
            video // do something
            repository().save(video);

            VideoPrecessed videoPrecessed = new VideoPrecessed(video);
            videoPrecessed.publishAfterCommit();

         });
        */

    }
}

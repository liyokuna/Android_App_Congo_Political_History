package eduuserslmukunaciowelapersonalwebsite.missouriwestern.httpwebservices.project_final;

/**
 * Created by MUKUNA CIOWELA on 04.05.16.
 */
public class Drawing {

    private String mDescription;
    private int mId; //identification of pictures

    public int getSoundID() {
        return soundID;
    }

    public void setSoundID(int soundID) {
        this.soundID = soundID;
    }

    private int soundID;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public Drawing(String Description, int id, int audioid){
        mDescription = Description;
        mId = id;
        soundID = audioid;
    }




}

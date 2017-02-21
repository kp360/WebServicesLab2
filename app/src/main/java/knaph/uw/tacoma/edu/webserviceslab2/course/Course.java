package knaph.uw.tacoma.edu.webserviceslab2.course;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Kyle on 2/12/17.
 */

public class Course implements Serializable {

    private String mId, mShortDesc, mLongDesc, mPrereqs;

    public static final String ID = "id", SHORT_DESC = "shortDesc", LONG_DESC = "longDesc",
            PRE_REQS = "prereqs";

    public Course(String id, String shortDesc, String longDesc, String prereqs) {
        mId = id;
        mShortDesc = shortDesc;
        mLongDesc = longDesc;
        mPrereqs = prereqs;
    }

    public String getId() { return mId; }

    public void setId(String id) { mId = id; }

    public String getShortDesc() { return mShortDesc; }

    public void setShortDesc(String shortDesc) { mShortDesc = shortDesc; }

    public String getLongDesc() { return mLongDesc; }

    public static String getPreqReqs() { return PRE_REQS; }

    public void setLongDesc(String longDesc) { mLongDesc = longDesc; }

    public String getPrereqs() { return mPrereqs; }

    public void setPrereqs(String prereqs) { mPrereqs = prereqs; }

    public static String getID() { return ID; }

    /**
     * Parses the json string, returns an error message if unsuccessful.
     * Returns course list if success.
     * @param courseJSON
     * @return reason or null if successful.
     */
    public static String parseCourseJSON(String courseJSON, List<Course> courseList) {
        String reason = null;
        if (courseJSON != null) {
            try {
                JSONArray arr = new JSONArray(courseJSON);

                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    Course course = new Course(obj.getString(Course.ID), obj.getString(Course.SHORT_DESC)
                            , obj.getString(Course.LONG_DESC), obj.getString(Course.PRE_REQS));
                    courseList.add(course);
                }
            } catch (JSONException e) {
                reason =  "Unable to parse data, Reason: " + e.getMessage();
            }

        }
        return reason;
    }

}

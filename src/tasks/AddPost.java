package tasks;

import DataBase.Controller;
import DataBase.DataBase;
import DataBase.datasController;
import models.Post;

public class AddPost {
    public static String addPost(String request) {
        String[] requestSplit = request.split(" ");
        return addPost(requestSplit[1], requestSplit[2], requestSplit[3], requestSplit[4]);
    }

    private static String addPost(String personId, String communityId, String title, String description) {
        Controller controller = DataBase.getControllert("CommunitiesPosts");
        String str = controller.readFile();
        int postID = Post.getNewId();
        int personID = Integer.parseInt(personId);
        int communityID = Integer.parseInt(communityId);
        controller.writeFile(postID + " " + personID + " " + communityID + " " + title + "\n" + description + " ");
        datasController controller2 = DataBase.getControllert2("CommunitiesPosts");
        controller2.createFile(postID + "");
        controller2.write(postID + "",
                personID + " " + communityID + " " + title + " " + "\n" + description + " {} {} {} {} {} {}");
        return "success " + postID;

    }
}

// title and discription
// title one line
// discription many line

// add post click
// addpost id communityId title \n discription

// switch case on addpost
// create post and id
// just add id in folder of community
// and add id to person file
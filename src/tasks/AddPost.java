package tasks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DataBase.Controller;
import DataBase.DataBase;
import DataBase.datasController;
import models.Post;

public class AddPost {
    public static String addPost(String request) {
        Pattern pattern = Pattern.compile("(?<UserId>[^ ]*) (?<comId>[^ ]*) (?<title>[^\n]*)\n(?<desc>[^\0]*)");
        Matcher matcher = pattern.matcher(request);
        return addPost(matcher.group("UserId"), matcher.group("comId"), matcher.group("title"), matcher.group("desc"));
    }

    private static String addPost(String personId, String communityId, String title, String description) {
        Controller controller = DataBase.getControllert("Posts");
        int postID = Post.getNewId();
        int personID = Integer.parseInt(personId);
        int communityID = Integer.parseInt(communityId);
        controller.writeFile(postID + " " + personID + " " + communityID);
        datasController controller2 = DataBase.getControllert2("Posts");
        controller2.createFile(postID + "");
        controller2.write(postID + " ", personID + " " + communityID + " {} " + title + "\n" + description);
        Controller communityController = DataBase.getControllert("communities/CommunitiesPosts");
        communityController.writeFile(postID + " " + personID + " " + communityID);
        datasController communityController2 = DataBase.getControllert2("communities/CommunitiesPosts");
        communityController2.createFile(postID + "");
        communityController2.write(postID + " ", personID + " " + communityID + " {} " + title + "\n" + description);
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
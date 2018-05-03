import java.util.ArrayList;
import java.util.List;

public class Blog {

    List<BlogPost> blogList;

    public Blog() {
        this.blogList = new ArrayList<>();
    }

    public void add(BlogPost blogpost) {
        this.blogList.add(blogpost);
    }

    public void delete(int index) {
        if (index <= this.blogList.size()) {
            this.blogList.remove(index);
        } else {
            System.out.println("There is no index");
        }
    }

    public void update(int index, BlogPost blogpost) {
        this.blogList.set(index, blogpost);
    }

    public BlogPost getBlogPost(int index) {
        return this.blogList.get(index);
    }

    //public int blogLength() {
    //    return this.blogList.size();
    //}

    public static void main(String[] args) {
        Blog blog = new Blog();
        blog.add(new BlogPost("John Doe",
                "Lorem Ipsum",
                "Lorem ipsum dolor sit amet.",
                "2000.05.04."));
        blog.add(new BlogPost("John Doe",
                "Lorem Ipsum",
                "Lorem ipsum dolor sit amet.",
                "2000.05.04."));
        blog.add(new BlogPost("Tim Urban",
                "Wait but why",
                "A popular long-form, stick-figure-illustrated blog about almost everything",
                "2010.10.10."));

        BlogPost blogPostForUpdating = new BlogPost("William Turton",
                "One Engineer Is Trying to Get IBM to Reckon With Trump",
                "Daniel Hanley, a cybersecurity engineer at IBM, doesn’t want to be the center of attention. When I asked to take his picture outside one of IBM’s New York City offices, he told me that he wasn’t really into the whole organizer profile thing.",
                "2017.03.28.");
        blog.update(1, blogPostForUpdating);

        System.out.println(blog.getBlogPost(1).authorName);

        blog.delete(1);
        //System.out.println(blogLength());
    }
}

package com.example.demo.database;

import com.example.demo.model.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseDB {
    public static List<Course> listCourse = new ArrayList<>(
            List.of(
                    new Course(1, "Java Developer Web", "Khóa học lập trình Java nâng cao", "hightTech",
                            List.of(
                                    CategoryDB.categories.get(0), CategoryDB.categories.get(1))
                            , null, 2869000, 5.0, 1),

                    new Course(2, "JavaScpirt Fullstack", "Khóa học lập trình Js nâng cao", "hightTech",
                            List.of(
                                    CategoryDB.categories.get(0), CategoryDB.categories.get(1))
                            , null, 350000, 5.0, 2),
                    new Course(3, "PHP FullStack Web", "Khóa học lập trình PHP nâng cao", "hightTech",
                            List.of(
                                    CategoryDB.categories.get(3), CategoryDB.categories.get(4))
                            , null, 558000, 4.0, 3)
            )
    );
}

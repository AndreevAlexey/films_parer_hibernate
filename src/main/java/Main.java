import model.Film;
import model.Year;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import service.Service;

import java.util.*;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        String html = "        <div class=\"movieList_item movieItem  movieItem-rating movieItem-position \"> \n" +
                      "         <a href=\"https://www.kinoafisha.info/movies/8326545/\"> \n" +
                      "          <picture class=\"movieItem_poster picture picture-poster\" data-modules=\"picture\">\n" +
                      "           <template>\n" +
                      "            <source srcset=\"https://static.kinoafisha.info/k/movie_posters/220/upload/movie_posters/5/4/5/8326545/509347f537e2ff2e9a6d2f34d40e1e9d.jpg.webp\" type=\"image/webp\">\n" +
                      "            <source srcset=\"https://static.kinoafisha.info/k/movie_posters/220/upload/movie_posters/5/4/5/8326545/509347f537e2ff2e9a6d2f34d40e1e9d.jpg\" type=\"image/jpeg\">\n" +
                      "           </template>\n" +
                      "           <img class=\"picture_image\" alt=\"Телохранитель киллера\" title=\"Телохранитель киллера\" src=\"data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7\" data-picture=\"https://static.kinoafisha.info/k/movie_posters/220/upload/movie_posters/5/4/5/8326545/509347f537e2ff2e9a6d2f34d40e1e9d.jpg\">\n" +
                      "          </picture> </a> \n" +
                      "         <div class=\"movieItem_info\"> \n" +
                      "          <span class=\"movieItem_position\">5</span> \n" +
                      "          <a class=\"movieItem_title\" href=\"https://www.kinoafisha.info/movies/8326545/\">Телохранитель киллера</a> \n" +
                      "          <div class=\"movieItem_details\"> \n" +
                      "           <span class=\"movieItem_genres\">боевик, комедия</span> \n" +
                      "           <span class=\"movieItem_year\">2017, США</span> \n" +
                      "          </div> \n" +
                      "          <div class=\"movieItem_actions\"> \n" +
                      "           <div data-rating-wrapper class=\"movieItem_rating rating rating-mark js-allowVote \" data-param=\"{&quot;type&quot;:&quot;movies&quot;,&quot;uid&quot;:&quot;8326545&quot;,&quot;stars&quot;:&quot;mark&quot;}\"> \n" +
                      "            <span class=\"rating_num\" data-rating-numrating>8.3</span> \n" +
                      "            <div data-modules=\"Rating\" class=\"rating_stars\"> \n" +
                      "             <span data-rating-value class=\"rating_val\" style=\"width:80%;\"></span> \n" +
                      "             <span data-rating-star=\"1\" class=\"rating_star rating_star-1\"></span> \n" +
                      "             <span data-rating-star=\"2\" class=\"rating_star rating_star-2\"></span> \n" +
                      "             <span data-rating-star=\"3\" class=\"rating_star rating_star-3\"></span> \n" +
                      "             <span data-rating-star=\"4\" class=\"rating_star rating_star-4\"></span> \n" +
                      "             <span data-rating-star=\"5\" class=\"rating_star rating_star-5\"></span> \n" +
                      "             <span data-rating-star=\"6\" class=\"rating_star rating_star-6\"></span> \n" +
                      "             <span data-rating-star=\"7\" class=\"rating_star rating_star-7\"></span> \n" +
                      "             <span data-rating-star=\"8\" class=\"rating_star rating_star-8\"></span> \n" +
                      "             <span data-rating-star=\"9\" class=\"rating_star rating_star-9\"></span> \n" +
                      "             <span data-rating-star=\"10\" class=\"rating_star rating_star-10\"></span> \n" +
                      "            </div> \n" +
                      "            <span data-rating-mark class=\"rating_text\"> Оцените </span> \n" +
                      "           </div> \n" +
                      "           <button class=\"movieItem_favBtn favBtn  favBtn-active\" data-fav-btn data-modules=\"Fav\" data-param=\"{&quot;type&quot;:&quot;movies&quot;, &quot;uid&quot;:&quot;8326545&quot;}\"> \n" +
                      "            <svg class=\"favBtn_icon symbol symbol-health\" role=\"img\">\n" +
                      "             <use xlink:href=\"#health\"></use>\n" +
                      "            </svg> </button> \n" +
                      "          </div> \n" +
                      "         </div> \n" +
                      "        </div> \n" +
                      "        <!--AdFox START --> \n" +
                      "        <div data-modules=\"banner\" id=\"kad3bxfm_156577305381854875\" class=\"movieList_ads aka13mga aka13mga-728 aka13mga-fix as-desktop\" data-lazy=\"[{&quot;ownerId&quot;:275464,&quot;containerId&quot;:&quot;kad3bxfm_156577305381854875&quot;,&quot;params&quot;:{&quot;p1&quot;:&quot;cgmac&quot;,&quot;p2&quot;:&quot;gmyr&quot;}},[&quot;desktop&quot;,&quot;tablet&quot;],{&quot;tabletWidth&quot;:1262,&quot;phoneWidth&quot;:758}]\" data-bidders=\"&quot;&quot;\"></div> \n" +
                      "        <!--AdFox START --> \n" +
                      "        <div data-modules=\"banner\" id=\"kad48h8x_155586733517958018\" class=\"movieList_ads aka13mga aka13mga-728 aka13mga-fix as-mobile\" data-lazy=\"[{&quot;ownerId&quot;:275464,&quot;containerId&quot;:&quot;kad48h8x_155586733517958018&quot;,&quot;params&quot;:{&quot;p1&quot;:&quot;celwb&quot;,&quot;p2&quot;:&quot;geel&quot;}},[&quot;phone&quot;],{&quot;tabletWidth&quot;:1262,&quot;phoneWidth&quot;:758}]\" data-bidders=\"&quot;&quot;\"></div> \n" +
                      "        <div class=\"movieList_item movieItem  movieItem-rating movieItem-position \"> \n" +
                      "         <a href=\"https://www.kinoafisha.info/movies/8170452/\"> \n" +
                      "          <picture class=\"movieItem_poster picture picture-poster\" data-modules=\"picture\">\n" +
                      "           <template>\n" +
                      "            <source srcset=\"https://static.kinoafisha.info/k/movie_posters/220/upload/movie_posters/2/5/4/8170452/37ec2ca1a3f5e9c18316a0e934a02ef6.jpeg.webp\" type=\"image/webp\">\n" +
                      "            <source srcset=\"https://static.kinoafisha.info/k/movie_posters/220/upload/movie_posters/2/5/4/8170452/37ec2ca1a3f5e9c18316a0e934a02ef6.jpeg\" type=\"image/jpeg\">\n" +
                      "           </template>\n" +
                      "           <img class=\"picture_image\" alt=\"Тор: Рагнарёк\" title=\"Тор: Рагнарёк\" src=\"data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7\" data-picture=\"https://static.kinoafisha.info/k/movie_posters/220/upload/movie_posters/2/5/4/8170452/37ec2ca1a3f5e9c18316a0e934a02ef6.jpeg\">\n" +
                      "          </picture> </a> \n" +
                      "         <div class=\"movieItem_info\"> \n" +
                      "          <span class=\"movieItem_position\">6</span> \n" +
                      "          <a class=\"movieItem_title\" href=\"https://www.kinoafisha.info/movies/8170452/\">Тор: Рагнарёк</a> \n" +
                      "          <div class=\"movieItem_details\"> \n" +
                      "           <span class=\"movieItem_genres\">фэнтези, драма, боевик</span> \n" +
                      "           <span class=\"movieItem_year\">2017, США</span> \n" +
                      "          </div> \n" +
                      "          <div class=\"movieItem_actions\"> \n" +
                      "           <div data-rating-wrapper class=\"movieItem_rating rating rating-mark js-allowVote \" data-param=\"{&quot;type&quot;:&quot;movies&quot;,&quot;uid&quot;:&quot;8170452&quot;,&quot;stars&quot;:&quot;mark&quot;}\"> \n" +
                      "            <span class=\"rating_num\" data-rating-numrating>8.3</span> \n" +
                      "            <div data-modules=\"Rating\" class=\"rating_stars\"> \n" +
                      "             <span data-rating-value class=\"rating_val\" style=\"width:80%;\"></span> \n" +
                      "             <span data-rating-star=\"1\" class=\"rating_star rating_star-1\"></span> \n" +
                      "             <span data-rating-star=\"2\" class=\"rating_star rating_star-2\"></span> \n" +
                      "             <span data-rating-star=\"3\" class=\"rating_star rating_star-3\"></span> \n" +
                      "             <span data-rating-star=\"4\" class=\"rating_star rating_star-4\"></span> \n" +
                      "             <span data-rating-star=\"5\" class=\"rating_star rating_star-5\"></span> \n" +
                      "             <span data-rating-star=\"6\" class=\"rating_star rating_star-6\"></span> \n" +
                      "             <span data-rating-star=\"7\" class=\"rating_star rating_star-7\"></span> \n" +
                      "             <span data-rating-star=\"8\" class=\"rating_star rating_star-8\"></span> \n" +
                      "             <span data-rating-star=\"9\" class=\"rating_star rating_star-9\"></span> \n" +
                      "             <span data-rating-star=\"10\" class=\"rating_star rating_star-10\"></span> \n" +
                      "            </div> \n" +
                      "            <span data-rating-mark class=\"rating_text\"> Оцените </span> \n" +
                      "           </div> \n" +
                      "           <button class=\"movieItem_favBtn favBtn  favBtn-active\" data-fav-btn data-modules=\"Fav\" data-param=\"{&quot;type&quot;:&quot;movies&quot;, &quot;uid&quot;:&quot;8170452&quot;}\"> \n" +
                      "            <svg class=\"favBtn_icon symbol symbol-health\" role=\"img\">\n" +
                      "             <use xlink:href=\"#health\"></use>\n" +
                      "            </svg> </button> \n" +
                      "          </div> \n" +
                      "         </div> \n" +
                      "        </div> ";
        /*
        try {
            Document doc = Jsoup.connect("https://www.kinoafisha.info/rating/movies/2017/")
                    .userAgent("Chrome/4.0.249.0 Safari/532.5")
                    .referrer("http://www.google.com")
                    .get();
            System.out.println("doc = " + doc.body());
            Elements listNews = doc.select("div.movieItem_info");
            System.out.println("\n\n!!!FILMS!!!!\n\n");
            for (Element element : listNews.select("a"))
                System.out.println(element.text());

        } catch (IOException e) {
            System.out.println("!!!errrorr");
            e.printStackTrace();
        }
        */
        Document doc = Jsoup.parse(html);
        //System.out.println("doc = " + doc.body());
        //Elements listNews = doc.select("div.movieItem_info");
        Elements listNews = doc.getElementsByClass("movieItem_info");

        //System.out.println("!listNews = " + listNews);

        //System.out.println("!!listNews html = " + listNews.html());

        //System.out.println("!!!listNews text = " + listNews.text());

        Service service = new Service();

        String year = "2017";
        Long id;

        Year currYear = new Year(year);
        Map<String, Long> years = service.getYearsMapFromDB();
        System.out.println("years.size = " + years.size());
        if(years.containsKey(year))
            id = years.get(year);
        else {
            service.addYearToDB(currYear);
            id =service.getYearIdFromDB(currYear.getVal());
        }
        System.out.println("year id = " + id);
        currYear.setId(id);

        years = service.getYearsMapFromDB();
        List<Film> films = new ArrayList<>();

        System.out.println("\n\n!!!FILMS!!!!\n\n");
        for (Element element : listNews) {
            System.out.println(element + "\n");
            System.out.println(element.text() + "\n\n");
            System.out.println("movieItem_position = " + element.getElementsByClass("movieItem_position").text());
            System.out.println("movieItem_title = " + element.getElementsByClass("movieItem_title").text());
            System.out.println("rating_num = " + element.getElementsByClass("rating_num").text());

            Film film = new Film();
            film.setYear(currYear);
            film.setName(element.getElementsByClass("movieItem_title").text());
            film.setReiting(element.getElementsByClass("rating_num").text());
            film.setPosition(Integer.parseInt(element.getElementsByClass("movieItem_position").text()));
            films.add(film);

        }
        service.addFilmsToDB(films);
        // TODO: переделать репозитории так, чтобы было только по одной зависимости ManagerDB <- YearRepository , ManagerDB <- FilmRepository
        // TODO сделать проверку на наличие фильмов за определенный год
        // TODO сделать обновление данных за год(удаление записей + вставка)
    }
}

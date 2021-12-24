package
        cn.edu.tongji.dwbackend.Mysql.service.impl;/**
 * @author 梁乔 2021/12/6
 **/

import cn.edu.tongji.dwbackend.Mysql.entity.*;
import cn.edu.tongji.dwbackend.Mysql.repository.*;
import cn.edu.tongji.dwbackend.Mysql.service.AssociationService;
import cn.edu.tongji.dwbackend.dto.MovieInfoDto;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.swing.text.html.HTMLDocument;
import java.sql.Timestamp;
import java.util.*;

/**
 * 此处写RelationShipServiceImpl类的描述
 * @author 梁乔
 * @since 2021/12/6 22:00
 */

@Service
public class AssociationServiceImpl implements AssociationService {
    @Resource
    MovieRepository movieRepository;

    @Resource
    DirectorMovieRepository directorMovieRepository;

    @Resource
    ViewDirectorNameRepository viewDirectorNameRepository;

    @Resource
    ViewActorNameRepository viewActorNameRepository;

    @Resource
    ViewCategoryNameRepository viewCategoryNameRepository;

    @Resource
    ActorMovieRepository actorMovieRepository;

    @Resource
    ViewActorActorRepository viewActorActorRepository;

    @Resource
    ViewActorDirectorRepository viewActorDirectorRepository;

    @Resource
    ViewActorCooperationTimeRepository viewActorCooperationTimeRepository;


    @Resource
    CategoryRepository categoryRepository;


    @Resource
    TimeRepository timeRepository;

    @Resource
    FormatRepository formatRepository;

    @Resource
    TimeMovieRepository timeMovieRepository;

    @Resource
    MovieScoreRepository movieScoreRepository;

    @Resource
    ViewDirectorCooperationTimeRespository viewDirectorCooperationTimeRespository;

    @Resource
    ViewActorDirectorCooperationTimeRespository viewActorDirectorCooperationTimeRespository;
    @Override
    public List<String> getMovieNameByStr(String movieString) {
        Pageable pageable = PageRequest.of(0, 25);
        List<MovieEntity> movieList = movieRepository.findAllByMovieNameStartingWith(movieString, pageable);

        List<String> result = new ArrayList<>();
        for (MovieEntity movie: movieList){
            result.add(movie.getMovieName());
        }

        return result;
    }

    @Override
    public List<String> getDirectorNameByStr(String directorName){
        Pageable pageable = PageRequest.of(0, 50);
        List<ViewDirectorNameEntity> directorList =
                viewDirectorNameRepository.findAllByDirectorNameStartingWith(directorName, pageable);

        List<String> result = new ArrayList<>();
        for (ViewDirectorNameEntity director: directorList){
            result.add(director.getDirectorName());
        }

        return result;
    }

    @Override
    public List<String> getActorNameByStr(String actorName){
        Pageable pageable = PageRequest.of(0, 50);
        List<ViewActorNameEntity> actorList =
                viewActorNameRepository.findAllByActorNameStartingWith(actorName, pageable);

        List<String> result = new ArrayList<>();
        for (ViewActorNameEntity actor: actorList){
            result.add(actor.getActorName());
        }

        return result;
    }

    @Override
    public List<String> getCategoryNameByStr(String category){
        Pageable pageable = PageRequest.of(0, 50);
        List<ViewCategoryNameEntity> categoryList =
                viewCategoryNameRepository.findAllByCategoryNameStartingWith(category, pageable);

        List<String> result = new ArrayList<>();
        for (ViewCategoryNameEntity categoryName: categoryList){
            result.add(categoryName.getCategoryName());
        }

        return result;
    }

    @Override
    public List<String> getAllDirectorsByMovieAsin(String movieAsin){
        MovieEntity movie = movieRepository.findFirstByMovieAsin(movieAsin);

        if(movie == null){
            return null;
        }

        List<DirectorMovieEntity> directorList = directorMovieRepository.findAllByMovieId(movie.getMovieId());
        List<String> result = new ArrayList<>();

        for(DirectorMovieEntity directorMovie: directorList){
            result.add(directorMovie.getDirectorName());
        }

        return result;
    }

    @Override
    public List<String> getAllMainActorsByMovieAsin(String movieAsin){
        MovieEntity movie = movieRepository.findFirstByMovieAsin(movieAsin);

        if(movie == null){
            return null;
        }

        byte b=1;
        List<ActorMovieEntity> mainActorList = actorMovieRepository.findAllByMovieIdAndIsMainActor(movie.getMovieId(), b);
        List<String> result = new ArrayList<>();

        for(ActorMovieEntity actorMovie: mainActorList){
            result.add(actorMovie.getActorName());
        }

        return result;
    }

    @Override
    public List<String> getAllActorsByMovieAsin(String movieAsin){
        MovieEntity movie = movieRepository.findFirstByMovieAsin(movieAsin);

        if(movie == null){
            return null;
        }

        byte b=0;
        List<ActorMovieEntity> mainActorList = actorMovieRepository.findAllByMovieIdAndIsMainActor(movie.getMovieId(), b);
        List<String> result = new ArrayList<>();

        for(ActorMovieEntity actorMovie: mainActorList){
            result.add(actorMovie.getActorName());
        }

        return result;
    }

    @Override
    public List<HashMap<String,Object>> getMovieNameByActorAndActor(String actor1, String actor2){
        List<ViewActorActorEntity> viewActorActorEntities
                = viewActorActorRepository.findAllByActor1AndActor2(actor1, actor2);
        List<HashMap<String,Object>> result = new ArrayList<>();

        for(ViewActorActorEntity viewActorActor: viewActorActorEntities){
            MovieEntity movie = movieRepository.findFirstByMovieId(viewActorActor.getMovieId());
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("asin",movie.getMovieAsin());
            hashMap.put("name",movie.getMovieName());
            hashMap.put("score",movie.getMovieScore());
            hashMap.put("commentNum",movie.getCommentNum());
            result.add(hashMap);
        }
        return result;
    }

    @Override
    public List<HashMap<String,Object>> getMovieNameByActorAndDirector(String actorName, String directorName) {
        List<ViewActorDirectorEntity> viewActorDirectorEntities
                = viewActorDirectorRepository.findAllByActorNameAndDirectorName(actorName, directorName);
        List<HashMap<String,Object>> result = new ArrayList<>();

        for (ViewActorDirectorEntity viewActorDirector : viewActorDirectorEntities) {
            MovieEntity movie = movieRepository.findFirstByMovieId(viewActorDirector.getMovieId());
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("asin",movie.getMovieAsin());
            hashMap.put("name",movie.getMovieName());
            hashMap.put("score",movie.getMovieScore());
            hashMap.put("commentNum",movie.getCommentNum());
            result.add(hashMap);
        }
        return result;
    }
    //返回合作次数最多的演员
    @Override
    public HashMap<String, Object> getMaxCooperationTimeOfActors() {
        ViewActorCooperationTimeEntity viewActorCooperationTimeEntity = viewActorCooperationTimeRepository.findTopBy();
        HashMap<String,Object> result = new HashMap<>();
        List<String> actors = new ArrayList<>();
        actors.add(viewActorCooperationTimeEntity.getActorName1());
        actors.add(viewActorCooperationTimeEntity.getActorName2());
        result.put("actor",actors);
        result.put("number",viewActorCooperationTimeEntity.getCooperTime());
        return result;
    }

    @Override
    public HashMap<String, Object> getMaxCooperationTimeOfDirectors() {
        ViewDirectorCooperationTimeEntity viewDirectorCooperationTimeEntity = viewDirectorCooperationTimeRespository.findTopBy();
        HashMap<String,Object> result = new HashMap<>();
        List<String> directors = new ArrayList<>();
        directors.add(viewDirectorCooperationTimeEntity.getDirectorName1());
        directors.add(viewDirectorCooperationTimeEntity.getDirectorName2());
        result.put("director",directors);
        result.put("number",viewDirectorCooperationTimeEntity.getCooperTime());
        return result;
    }

    @Override
    public HashMap<String, Object> getMaxCooperationTimeOfActorsAndDiectors() {
        ViewActorDirectorCooperationTimeEntity viewActorDirectorCooperationTimeEntity = viewActorDirectorCooperationTimeRespository.findTopBy();
        HashMap<String,Object> result = new HashMap<>();
        result.put("actor",viewActorDirectorCooperationTimeEntity.getActorName());
        result.put("director",viewActorDirectorCooperationTimeEntity.getDirectorName());
        result.put("number",viewActorDirectorCooperationTimeEntity.getMovieCount());
        return  result;
    }

    //根据多条件筛选电影
    @Override
    public HashMap<String, Object> getMovieResultsByMutipleRules(MovieInfoDto movieInfoDto) {
        HashMap<String,Object> result = new HashMap<>();
//        Specification<ViewMovieFactEntity> spec = (root, query, criteriaBuilder) -> {
//            ArrayList<Predicate> list = new ArrayList<>();
//            if(movieInfoDto.getMovieName() != null)//加入电影名称谓词
//                list.add(criteriaBuilder.equal(root.get("movieName"),movieInfoDto.getMovieName()));
//            if(movieInfoDto.getCategory()!= null)//加入电影类别谓词
//                list.add(criteriaBuilder.equal(root.get("categoryName"),movieInfoDto.getCategory()));
//            if(movieInfoDto.getDirectorNames() != null){
//                for(String directorName:movieInfoDto.getDirectorNames()){
//                    list.add(criteriaBuilder.equal(root.get("directorName"),directorName));
//                }
//            }
//            if(movieInfoDto.getMainActors() != null){
//                for(String mainActor:movieInfoDto.getMainActors()){
//                    list.add(criteriaBuilder.equal(root.get("isMainActor"),1));
//                    list.add(criteriaBuilder.equal(root.get("actorName"),mainActor));
//                }
//            }
//            if(movieInfoDto.getMinScore() != null)
//                list.add(criteriaBuilder.ge(root.get("movieScore"),Double.valueOf(movieInfoDto.getMinScore())));
//            if(movieInfoDto.getMaxScore() != null)
//                list.add(criteriaBuilder.le(root.get("movieScore"),Double.valueOf(movieInfoDto.getMaxScore())));
//            if(movieInfoDto.getMinYear() != null)
//                list.add(criteriaBuilder.ge(root.get("year"),movieInfoDto.getMinYear().shortValue()));
//            if(movieInfoDto.getMaxYear() != null)
//                list.add(criteriaBuilder.le(root.get("year"),movieInfoDto.getMaxYear().shortValue()));
//            if(movieInfoDto.getMinMonth() != null)
//                list.add(criteriaBuilder.ge(root.get("month"),movieInfoDto.getMinMonth().shortValue()));
//            if(movieInfoDto.getMaxMonth() != null)
//                list.add(criteriaBuilder.le(root.get("month"),movieInfoDto.getMaxMonth().shortValue()));
//            if(movieInfoDto.getMinDay() != null)
//                list.add(criteriaBuilder.le(root.get("day"),movieInfoDto.getMinDay().shortValue()));
//
//            Predicate[] array = new Predicate[list.size()];
//            Predicate[] predicates = list.toArray(array);
//            return criteriaBuilder.or(predicates);
//        };
//        List<ViewMovieFactEntity> viewMovieFactEntities = viewModelFactRepository.findAll(spec);
//        result.put("result",viewMovieFactEntities);

        //电影名称查询
        long startTime = System.currentTimeMillis();
        List<MovieEntity> movieEntitiesOfMovieName  = new ArrayList<>();
        List<CategoryEntity> categoryEntitiesOfCategory =  new ArrayList<>();
        Set<Integer> resultMovieIdList = new HashSet<>();

        //当前已经得到的筛选条件数
        Integer rulesNumber = 0;

        if(movieInfoDto.getMovieName() != null){
            rulesNumber++;
            movieEntitiesOfMovieName = movieRepository.findAllByMovieName(movieInfoDto.getMovieName());
            for(MovieEntity movieEntity:movieEntitiesOfMovieName){
                resultMovieIdList.add(movieEntity.getMovieId());
            }
        }
        //电影类别查询
        if(movieInfoDto.getCategory() != null){

            categoryEntitiesOfCategory = categoryRepository.findAllByCategoryName(movieInfoDto.getCategory());
            Set<Integer> movieIdOfCategory = new HashSet<>();
            for(CategoryEntity category:categoryEntitiesOfCategory){
                movieIdOfCategory.add(category.getMovieId());
            }
            if(rulesNumber != 0){
                resultMovieIdList.retainAll(movieIdOfCategory);
            }
            else {
                resultMovieIdList = movieIdOfCategory;
            }
            rulesNumber++;
        }
        // 电影导演查询
        if(movieInfoDto.getDirectorNames() != null){
            List<DirectorMovieEntity> directorMovieEntities = new ArrayList<>();
            Set<Integer> movieIdOfDirector = new HashSet<>();
            //筛选出导演实体
            for(int i =0;i<movieInfoDto.getDirectorNames().size();i++){
                if(i==0){
                    directorMovieEntities = directorMovieRepository.findAllByDirectorName(movieInfoDto.getDirectorNames().get(i));
                    for(DirectorMovieEntity directorMovieEntity:directorMovieEntities){
                        movieIdOfDirector.add(directorMovieEntity.getMovieId());
                    }
                }
                else{
                    directorMovieEntities = directorMovieRepository.findAllByDirectorName(movieInfoDto.getDirectorNames().get(i));
                    Set<Integer> movieIdSet = new HashSet<>();
                    for(DirectorMovieEntity directorMovieEntity:directorMovieEntities){
                        movieIdSet.add(directorMovieEntity.getMovieId());
                    }
                    movieIdOfDirector.retainAll(movieIdSet);
                }
            }
            if(rulesNumber!=0){
                resultMovieIdList.retainAll(movieIdOfDirector);
            }
            else {
                resultMovieIdList = movieIdOfDirector;
            }
            rulesNumber++;
         }

        //主演查询
        if(movieInfoDto.getMainActors() != null){
            List<ActorMovieEntity> actorMovieEntities = new ArrayList<>();
            Set<Integer> movieIdOfMainActors = new HashSet<>();
            for(int i=0; i<movieInfoDto.getMainActors().size();i++){
                byte isMainActor = 1;
                if(i == 0){
                    actorMovieEntities = actorMovieRepository.findAllByActorNameAndIsMainActor(movieInfoDto.getMainActors().get(i), isMainActor);
                    for(ActorMovieEntity actorMovieEntity:actorMovieEntities){
                        movieIdOfMainActors.add(actorMovieEntity.getMovieId());
                    }
                }
               else{
                   actorMovieEntities = actorMovieRepository.findAllByActorNameAndIsMainActor(movieInfoDto.getMainActors().get(i), isMainActor);
                   Set<Integer> movieIdSet = new HashSet<>();
                   for(ActorMovieEntity actorMovieEntity:actorMovieEntities){
                       movieIdSet.add(actorMovieEntity.getMovieId());
                   }
                   movieIdOfMainActors.retainAll(movieIdSet);
                }
            }
            if(rulesNumber != 0){//前面已经有条件，直接进行交集
                resultMovieIdList.retainAll(movieIdOfMainActors);
            }
            else{
                resultMovieIdList = movieIdOfMainActors;
            }
            rulesNumber++;
        }

        //演员查询
        if(movieInfoDto.getActors() != null){
            List<ActorMovieEntity> actorMovieEntities = new ArrayList<>();
            Set<Integer> movieIdOfActors = new HashSet<>();
            for(int i=0; i<movieInfoDto.getActors().size();i++){
                byte isMainActor = 0;
                if(i == 0)
                {
                    actorMovieEntities = actorMovieRepository.findAllByActorNameAndIsMainActor(movieInfoDto.getActors().get(i), isMainActor);
                    for(ActorMovieEntity actorMovieEntity:actorMovieEntities){
                        movieIdOfActors.add(actorMovieEntity.getMovieId());
                    }
                }
                else{
                    actorMovieEntities = actorMovieRepository.findAllByActorNameAndIsMainActor(movieInfoDto.getActors().get(i), isMainActor);
                    Set<Integer> movieIdSet = new HashSet<>();
                    for(ActorMovieEntity actorMovieEntity:actorMovieEntities){
                        movieIdSet.add(actorMovieEntity.getMovieId());
                    }
                    movieIdOfActors.retainAll(movieIdSet);
                }
            }
            for(ActorMovieEntity actorMovieEntity:actorMovieEntities){
                movieIdOfActors.add(actorMovieEntity.getMovieId());
            }
            if(rulesNumber != 0){//前面已经有条件，直接进行交集
                resultMovieIdList.retainAll(movieIdOfActors);
            }
            else{
                resultMovieIdList = movieIdOfActors;
            }
            rulesNumber++;
        }

        //按照最大最小值查找
        if(movieInfoDto.getMinScore() != null && movieInfoDto.getMaxScore() !=null){
            List<MovieScoreEntity> movieScoreEntityList = movieScoreRepository.findAllByMovieScoreGreaterThanEqualAndMovieScoreLessThanEqual(Double.parseDouble(movieInfoDto.getMinScore()),Double.parseDouble(movieInfoDto.getMaxScore()));
            Set<Integer> movieIdOfScore = new HashSet<>();
            for(MovieScoreEntity movieScoreEntity:movieScoreEntityList){
                movieIdOfScore.add(movieScoreEntity.getMovieId());
            }
            if(rulesNumber != 0){
                resultMovieIdList.retainAll(movieIdOfScore);
            }
            else {
                resultMovieIdList = movieIdOfScore;
            }
            rulesNumber++;
        }
        else if(movieInfoDto.getMinScore() != null){
           List<MovieScoreEntity> movieScoreEntityList = movieScoreRepository.findAllByMovieScoreGreaterThanEqual(Double.parseDouble(movieInfoDto.getMinScore()));
            Set<Integer> movieIdOfMinScore = new HashSet<>();
            for(MovieScoreEntity movieScore:movieScoreEntityList){
                movieIdOfMinScore.add(movieScore.getMovieId());
            }
            if(rulesNumber != 0){
                resultMovieIdList.retainAll(movieIdOfMinScore);
            }
            else {
                resultMovieIdList = movieIdOfMinScore;
            }
            rulesNumber++;
        }
        else if(movieInfoDto.getMaxScore() != null){
            List<MovieScoreEntity> movieScoreEntityList = movieScoreRepository.findAllByMovieScoreLessThanEqual(Double.parseDouble(movieInfoDto.getMaxScore()));
            Set<Integer> movieIdOfMaxScore = new HashSet<>();
            for(MovieScoreEntity movieScore:movieScoreEntityList){
                movieIdOfMaxScore.add(movieScore.getMovieId());
            }
            if(rulesNumber != 0){
                resultMovieIdList.retainAll(movieIdOfMaxScore);
            }
            else {
                resultMovieIdList = movieIdOfMaxScore;
            }
            rulesNumber++;
        }

        //按照日期查询
        if(movieInfoDto.getMinDay() != null){//由于前端是选择时间段，当这个参数不为空时，六个参数都不为空

            //获取最小日期的str
            String minDateStr = movieInfoDto.getMinYear().toString()+"-"+
                    (movieInfoDto.getMinMonth()<10?"0"+movieInfoDto.getMinMonth().toString():movieInfoDto.getMinMonth().toString())+
                    "-"+(movieInfoDto.getMinDay()<10?"0"+movieInfoDto.getMinDay().toString():movieInfoDto.getMinDay().toString())
                    +" 00:00:00";
            //获取最大日期的str
            String maxDateStr = movieInfoDto.getMaxYear().toString()+"-"+
                    (movieInfoDto.getMaxMonth()<10?"0"+movieInfoDto.getMaxMonth().toString():movieInfoDto.getMaxMonth().toString())+
                    "-"+(movieInfoDto.getMaxDay()<10?"0"+movieInfoDto.getMaxDay().toString():movieInfoDto.getMaxDay().toString())
                    +" 00:00:00";

            Timestamp minDate = Timestamp.valueOf(minDateStr);
            Timestamp maxDate = Timestamp.valueOf(maxDateStr);

            Set<Integer> movieIdOfDate = new HashSet<>();
            //List<MovieEntity> movieEntities = new ArrayList<>();
            //List<MovieEntity> movieEntities = movieRepository.findAllByTimeStrAfterAndTimeStrBefore(minDate, maxDate);


            //尝试使用time_movie表
            //List<TimeEntity> timeEntities = timeRepository.findAllByTimeStrAfterAndTimeStrBefore(minDate,maxDate);

//            for(TimeEntity timeEntity:timeEntities){
//                movieEntities.addAll(movieRepository.findAllByTimeId(timeEntity.getTimeId()));
//            }
            List<TimeMovieEntity> timeMovieEntities = timeMovieRepository.findAllByTimeStrAfterAndTimeStrBefore(minDate,maxDate);
            for(TimeMovieEntity timeMovieEntity:timeMovieEntities){
                movieIdOfDate.add(timeMovieEntity.getMovieId());
            }
//            for(MovieEntity movieEntity:movieEntities){
//                movieIdOfDate.add(movieEntity.getMovieId());
//            }
            if(rulesNumber != 0){
                resultMovieIdList.retainAll(movieIdOfDate);
            }
            else {
                resultMovieIdList = movieIdOfDate;
            }
        }

        long endTime = System.currentTimeMillis();
        //查询完毕
        //开始输出结果
        List<HashMap<String, Object>> movieResult = new ArrayList<>();
        int resultNum = 0;
        for(Integer movieId:resultMovieIdList){
            resultNum++;
            HashMap<String, Object> movieNode = new HashMap<>();//单个电影信息节点
            MovieEntity movieEntity = movieRepository.findByMovieId(movieId);
            movieNode.put("asin",movieEntity.getMovieAsin());
            movieNode.put("title",movieEntity.getMovieName());


            //添加冗余字段 format——name
            Integer formatId = movieEntity.getFormatId();
            FormatEntity formatEntity =  formatRepository.findByFormatId(formatId);
            if(formatEntity != null) {
                movieNode.put("format", formatEntity.getFormatName());
            }
            movieNode.put("edition",movieEntity.getMovieEdition());
            movieNode.put("score",movieEntity.getMovieScore());
            movieNode.put("commentNum",movieEntity.getCommentNum());

            //这里使用冗余字段time_str对结果的join作了优化,少join一张表

            Date timeDate = movieEntity.getTimeStr();
            Calendar calendar = Calendar.getInstance();
            if(timeDate != null) {
                calendar.setTime(timeDate);
                movieNode.put("year", calendar.get(Calendar.YEAR));
                movieNode.put("month", calendar.get(Calendar.MONTH));
                movieNode.put("day", calendar.get(Calendar.DATE));
            }

//            TimeEntity timeEntity = timeRepository.findByTimeId(movieEntity.getTimeId());
//            if(timeEntity != null) {
//                movieNode.put("year", timeEntity.getYear());
//                movieNode.put("month", timeEntity.getMonth());
//                movieNode.put("day", timeEntity.getDay());
//            }
            movieResult.add(movieNode);
            if(resultNum == 50){
                break;
            }
        }
        result.put("movies",movieResult);
        result.put("movieNum",resultMovieIdList.size());

        result.put("time",endTime-startTime);
        return result;
    }
}
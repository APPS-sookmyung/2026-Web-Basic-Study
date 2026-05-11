import Movie from "../components/Movie";
import movieData from "../mock/dummy.json";

function MainPage() {
  return (
    <div className="main-container">
      <div className="movie-grid">
        {/* 데이터 배열을 돌며 Movie 컴포넌트 생성 */}
        {movieData.map((movie)=>(
         <Movie key={movie.id} movie={movie} />
        ))}
      </div>
    </div>
  );
}

export default MainPage;

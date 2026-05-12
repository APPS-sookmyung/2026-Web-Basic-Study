// Movie.jsx에서 Movie 라는 컴포넌트 불러오기
import Movie from "/src/components/Movie";
import movieData from "/src/mock/dummy.json";

function MainPage() {
  return (
    <div className="main-container">
      <div className="movie-grid">
        {/* map : 배열을 순회하는 메서드 */}
        { movieData.map((movie) => (
          <Movie key={movie.id} movie={movie}
          />
        ))}
      </div>
    </div>
  );
}

export default MainPage;

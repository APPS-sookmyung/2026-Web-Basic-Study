import Movie from "/src/components/Movie";
import movieData from "/src/mock/dummy.json";

function MainPage() {
  return (
    <div className="main-container">
      <div className="movie-grid">
        
        {
          movieData.map((item) => (
          <Movie key={item.id} movie={item} />
        ))         
        }
      </div>
    </div>
  );
}

export default MainPage;
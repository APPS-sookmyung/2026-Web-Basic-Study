import { useState, useEffect } from "react"; 
import { BrowserRouter, Routes, Route } from "react-router-dom";
// import movieData from "./mock/dummy.json"; 
import Header from "./components/Header";
import MainPage from "./page/MainPage";
import FavoritePage from "./page/FavoritePage";
import MoviePage from "./page/MoviePage";
import AddMoviePage from "./page/AddMoviePage";

import "./App.css";

export default function App() {
  const [movies, setMovies] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");

  const API_KEY = import.meta.env.VITE_TMDB_API_KEY;
  const API_URL = `https://api.themoviedb.org/3/movie/popular?api_key=${API_KEY}&language=ko-KR&page=1`;

  useEffect(() => {
    const fetchMovies = async () => {
      try {
        const response = await fetch(API_URL);
        if (!response.ok) {
          throw new Error("네트워크 응답에 실패했습니다.");
        }

        const data = await response.json();

        const formattedMovies = data.results.map((movie) => ({
          ...movie,
          isLiked: false,
          posterImgUrl: movie.poster_path
            ? `https://image.tmdb.org/t/p/w500${movie.poster_path}`
            : "https://via.placeholder.com/500x750?text=No+Poster",
          subTitle: movie.original_title,
          description: movie.overview,
          genres: movie.genre_ids.map((id) => "영화"),
        }));
        
        setMovies(formattedMovies);
      } catch (error) {
        console.error("영화 API를 가져오는 중 오류 발생:", error);
      }
    };

    fetchMovies();
  }, [API_KEY]); 

  const toggleHeart = (id) => {
    setMovies((prevMovies) =>
      prevMovies.map((movie) =>
        movie.id === id ? { ...movie, isLiked: !movie.isLiked } : movie,
      ),
    );
  };

  const deleteMovie = (id) => {
    if (window.confirm("정말로 이 영화를 삭제하시겠습니까?")) {
      setMovies((prevMovies) => prevMovies.filter((movie) => movie.id !== id));
    }
  };

  const handleSearch = (e) => {
    setSearchTerm(e.target.value);
  };

  const filteredMovies = movies.filter((movie) =>
    movie.title.toLowerCase().includes(searchTerm.toLowerCase()),
  );

  return (
    <BrowserRouter>
      <Header onSearch={handleSearch} />
      <Routes>
        <Route
          path="/"
          element={
            <MainPage
              movies={filteredMovies}
              onToggle={toggleHeart}
              onDelete={deleteMovie}
            />
          }
        />
        <Route
          path="/favorites"
          element={
            <FavoritePage
              movies={movies.filter((m) => m.isLiked)}
              onToggle={toggleHeart}
              onDelete={deleteMovie}
            />
          }
        />
        <Route
          path="/movie/:id"
          element={
            <MoviePage
              movies={movies}
              onToggle={toggleHeart}
              onDelete={deleteMovie}
            />
          }
        />
        <Route
          path="/add"
          element={<AddMoviePage movies={movies} setMovies={setMovies} />}
        />
      </Routes>
    </BrowserRouter>
  );
}

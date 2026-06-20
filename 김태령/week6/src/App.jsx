import { useState } from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import movieData from "./mock/dummy.json"; // 원본 데이터
import Header from "./components/Header";
import MainPage from "./page/MainPage";
import FavoritePage from "./page/FavoritePage";
import MoviePage from "./page/MoviePage";
import AddMoviePage from "./page/AddMoviePage"; // ⭐ 영화 추가 페이지 임포트

import "./App.css";

export default function App() {
  // 1. 모든 영화 데이터에 isLiked 속성을 추가하여 상태(State)로 관리합니다.
  const [movies, setMovies] = useState(
    movieData.map((movie) => ({ ...movie, isLiked: false })),
  );

  // 2. 하트를 누를 때 실행될 함수 (상태 변경 로직)
  // 기존 영화 배열을 순회하며, id가 일치하는 영화의 isLiked 상태만 반전시킨 새로운 배열을 반환
  const toggleHeart = (id) => {
    setMovies((prevMovies) =>
      prevMovies.map((movie) =>
        movie.id === id ?
          { ...movie, isLiked: !movie.isLiked }
          : movie
      ),
    );
  };

  return (
    <BrowserRouter>
      <Header />
      <Routes>
        
        <Route
          path="/"
          element={<MainPage movies={movies} onToggle={toggleHeart} />}
        />
        
        <Route
          path="/favorites"
          element={
            <FavoritePage
              movies={movies.filter((m) => m.isLiked)}
              onToggle={toggleHeart}
            />
          }
        />
        
        <Route
          path="/movie/:id"
          element={<MoviePage movies={movies} onToggle={toggleHeart} />}
        />
        
        <Route
          path="/add"
          element={<AddMoviePage movies={movies} setMovies={setMovies} />}
        />
      </Routes>
    </BrowserRouter>
  );
}
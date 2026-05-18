import React from 'react';
import Movie from "../components/Movie";
import movieData from "../mock/dummy.json";

export default function MainPage() {
  return (
    <div className="main-container">
      <div className="movie-grid">
        {movieData?.map((movie) => (
          <Movie key={movie.id} movie={movie} />
        ))}
      </div>
    </div>
  );
}
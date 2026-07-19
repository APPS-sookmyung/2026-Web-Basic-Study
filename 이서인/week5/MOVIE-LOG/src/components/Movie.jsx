import React, { useState, useEffect } from 'react';

export default function Movie({ movie, onFavoriteChange }) {
  const [isFavorite, setIsFavorite] = useState(false);

  useEffect(() => {
    const savedFavorites = JSON.parse(localStorage.getItem('favorites')) || [];
    const isSaved = savedFavorites.some((fav) => fav.id === movie.id);
    setIsFavorite(isSaved);
  }, [movie.id]);

  const toggleFavorite = (e) => {
    e.stopPropagation();
    
    const savedFavorites = JSON.parse(localStorage.getItem('favorites')) || [];
    let updatedFavorites;

    if (isFavorite) {
      updatedFavorites = savedFavorites.filter((fav) => fav.id !== movie.id);
    } else {
      updatedFavorites = [...savedFavorites, movie];
    }

    localStorage.setItem('favorites', JSON.stringify(updatedFavorites));
    setIsFavorite(!isFavorite);

    if (onFavoriteChange) {
      onFavoriteChange();
    }
  };

  return (
    <div className="movie-container">
      <img src={movie.posterImgUrl} alt={movie.title} />
      
      <button 
        className={`favorite-btn ${isFavorite ? 'active' : ''}`} 
        onClick={toggleFavorite}
      >
        ♥
      </button>

      <div className="movie-info">
        <h4>{movie.title}</h4>
        <p className="description">{movie.description}</p>
      </div>
    </div>
  );
}
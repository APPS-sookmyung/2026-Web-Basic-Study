import React from "react";
import { Link } from "react-router-dom";

export default function Header() {
  return (
    <header className="header">
      <h1 className="logo">
        <Link to="/" style={{ textDecoration: "none", color: "inherit" }}>
          🎬 Movie Log
        </Link>
      </h1>
    </header>
  );
}
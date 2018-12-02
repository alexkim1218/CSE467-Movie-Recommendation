package com.movie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.movie.bean.Movie;

public class MovieDao {
	public List<Movie> queryMovieList(String search_text) {
		List<Movie> movieList = new ArrayList<Movie>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie?useUnicode=true&characterEncoding=utf8","root","admin" );
			StringBuilder sql = new StringBuilder(" SELECT * FROM movie where 1=1 ");
			List<String> paramList = new ArrayList<String>();
			if(search_text != null && !"".equals(search_text.trim())){
				sql.append("and concat(movie_title,plot) like ? ");
				paramList.add("%"+search_text+"%");
			}
			PreparedStatement ptmt = conn.prepareStatement(sql.toString());
			for(int i=0;i<paramList.size();i++){
				ptmt.setString(i+1,paramList.get(i));
			}
			ResultSet rs =  ptmt.executeQuery();
			while(rs.next()){
				Movie movie = new Movie();
				movieList.add(movie);
				movie.setIndex(rs.getInt("index"));
				movie.setMovie_title(rs.getString("movie_title"));
				movie.setPlot(rs.getString("plot"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movieList;
	}
}

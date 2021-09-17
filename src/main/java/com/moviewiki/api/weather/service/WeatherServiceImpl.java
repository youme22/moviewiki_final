package com.moviewiki.api.weather.service;

import com.moviewiki.api.movie.domain.Movie;
import com.moviewiki.api.weather.domain.Weather;
import com.moviewiki.api.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    WeatherRepository weatherRepository;

    @Autowired
    EntityManager em;

    /* 영화의 날씨점수 등록 및 업데이트 */
    @Override
    @Transactional
    public void save(Movie movie, String weatherName, int weatherPoint) {

        Weather weather = new Weather();
        weather.setMovie(movie);
        weather.setWeatherName(weatherName);
        weather.setWeatherPoint(weatherPoint);

        em.persist(weather);
    }

    /* 특정날씨의 점수에 따른 정렬 */
    @Override
    public List<Weather> findByWeatherNameOrderByWeatherPointDesc(String weatherName) {
        return weatherRepository.findByWeatherNameOrderByWeatherPointDesc(weatherName);
    }
}

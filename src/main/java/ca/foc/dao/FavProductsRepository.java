package ca.foc.dao;

import ca.foc.domain.FavouriteProducts;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FavProductsRepository extends CrudRepository<FavouriteProducts,Integer> {

//
//    @Override
//    public <S extends FavouriteProducts> S save(S s) {
//        return s;
//    }
//
//    @Override
//    public <S extends FavouriteProducts> Iterable<S> saveAll(Iterable<S> iterable) {
//        return null;
//    }
//
//    @Override
//    public Optional<FavouriteProducts> findById(Integer integer) {
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean existsById(Integer integer) {
//        return false;
//    }
//
//    @Override
//    public Iterable<FavouriteProducts> findAll() {
//        return null;
//    }
//
//    @Override
//    public Iterable<FavouriteProducts> findAllById(Iterable<Integer> iterable) {
//        return null;
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(Integer integer) {
//
//    }
//
//    @Override
//    public void delete(FavouriteProducts favouriteProducts) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends FavouriteProducts> iterable) {
//
//    }
//
//    @Override
//    public void deleteAll() {

  //  }
}

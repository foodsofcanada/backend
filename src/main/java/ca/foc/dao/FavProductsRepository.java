package ca.foc.dao;

import ca.foc.domain.FavouriteProducts;
import ca.foc.domain.FavouriteProductsIdentity;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FavProductsRepository extends CrudRepository<FavouriteProducts, FavouriteProductsIdentity> {


//    @Override
//    public <S extends FavouriteProducts> S save(S s);

    @Override
    public <S extends FavouriteProducts> Iterable<S> saveAll(Iterable<S> iterable);

   // @Override
   // public Optional<FavouriteProducts> findById(Integer integer);

    @Override
    public boolean existsById(FavouriteProductsIdentity id);

    @Override
    public Iterable<FavouriteProducts> findAll();

    @Override
    public Iterable<FavouriteProducts> findAllById(Iterable<FavouriteProductsIdentity> iterable);

    @Override
    public long count();

//    @Override
//    public void deleteById(Integer integer);

    @Override
    public void delete(FavouriteProducts favouriteProducts);

    @Override
    public void deleteAll(Iterable<? extends FavouriteProducts> iterable);

    @Override
    public void deleteAll();
}

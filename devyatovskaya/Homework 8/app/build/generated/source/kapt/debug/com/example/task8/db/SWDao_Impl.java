package com.example.task8.db;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.task8.db.model.FilmDbModel;
import com.example.task8.db.model.PlanetsDbModel;
import com.example.task8.db.model.StarShipDbModel;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SWDao_Impl implements SWDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FilmDbModel> __insertionAdapterOfFilmDbModel;

  private final EntityInsertionAdapter<PlanetsDbModel> __insertionAdapterOfPlanetsDbModel;

  private final EntityInsertionAdapter<StarShipDbModel> __insertionAdapterOfStarShipDbModel;

  private final SharedSQLiteStatement __preparedStmtOfRemoveAllFilms;

  private final SharedSQLiteStatement __preparedStmtOfRemoveAllPlanets;

  private final SharedSQLiteStatement __preparedStmtOfRemoveAllShips;

  public SWDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFilmDbModel = new EntityInsertionAdapter<FilmDbModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `films` (`id`,`title`,`episodeId`,`director`,`producer`,`openingCrawl`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FilmDbModel value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        stmt.bindLong(3, value.getEpisodeId());
        if (value.getDirector() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDirector());
        }
        if (value.getProducer() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getProducer());
        }
        if (value.getOpeningCrawl() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getOpeningCrawl());
        }
      }
    };
    this.__insertionAdapterOfPlanetsDbModel = new EntityInsertionAdapter<PlanetsDbModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `planets` (`id`,`name`,`diameter`,`orbitalPeriod`,`rotationPeriod`,`gravity`,`population`,`climate`,`terrain`,`surfaceWater`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PlanetsDbModel value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getDiameter() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDiameter());
        }
        if (value.getOrbitalPeriod() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOrbitalPeriod());
        }
        if (value.getRotationPeriod() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getRotationPeriod());
        }
        if (value.getGravity() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getGravity());
        }
        if (value.getPopulation() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPopulation());
        }
        if (value.getClimate() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getClimate());
        }
        if (value.getTerrain() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getTerrain());
        }
        if (value.getSurfaceWater() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getSurfaceWater());
        }
      }
    };
    this.__insertionAdapterOfStarShipDbModel = new EntityInsertionAdapter<StarShipDbModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `starships` (`id`,`name`,`model`,`starshipClass`,`manufacturer`,`costInCredits`,`length`,`crew`,`passengers`,`maxAtmospheringSpeed`,`hyperdriveRating`,`MGLT`,`cargoCapacity`,`consumables`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, StarShipDbModel value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getModel() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getModel());
        }
        if (value.getStarshipClass() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getStarshipClass());
        }
        if (value.getManufacturer() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getManufacturer());
        }
        if (value.getCostInCredits() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCostInCredits());
        }
        if (value.getLength() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getLength());
        }
        if (value.getCrew() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCrew());
        }
        if (value.getPassengers() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getPassengers());
        }
        if (value.getMaxAtmospheringSpeed() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getMaxAtmospheringSpeed());
        }
        if (value.getHyperdriveRating() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getHyperdriveRating());
        }
        if (value.getMGLT() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getMGLT());
        }
        if (value.getCargoCapacity() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getCargoCapacity());
        }
        if (value.getConsumables() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getConsumables());
        }
      }
    };
    this.__preparedStmtOfRemoveAllFilms = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM films";
        return _query;
      }
    };
    this.__preparedStmtOfRemoveAllPlanets = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM planets";
        return _query;
      }
    };
    this.__preparedStmtOfRemoveAllShips = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM starships";
        return _query;
      }
    };
  }

  @Override
  public Object insertAllFilms(final List<FilmDbModel> items, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFilmDbModel.insert(items);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object insertAllPlanets(final List<PlanetsDbModel> items,
      final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPlanetsDbModel.insert(items);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object insertAllShips(final List<StarShipDbModel> items,
      final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfStarShipDbModel.insert(items);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object removeAllFilms(final Continuation<? super Unit> p0) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveAllFilms.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfRemoveAllFilms.release(_stmt);
        }
      }
    }, p0);
  }

  @Override
  public Object removeAllPlanets(final Continuation<? super Unit> p0) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveAllPlanets.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfRemoveAllPlanets.release(_stmt);
        }
      }
    }, p0);
  }

  @Override
  public Object removeAllShips(final Continuation<? super Unit> p0) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveAllShips.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfRemoveAllShips.release(_stmt);
        }
      }
    }, p0);
  }

  @Override
  public Object getAllFilms(final Continuation<? super List<FilmDbModel>> p0) {
    final String _sql = "SELECT * FROM films";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<FilmDbModel>>() {
      @Override
      public List<FilmDbModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfEpisodeId = CursorUtil.getColumnIndexOrThrow(_cursor, "episodeId");
          final int _cursorIndexOfDirector = CursorUtil.getColumnIndexOrThrow(_cursor, "director");
          final int _cursorIndexOfProducer = CursorUtil.getColumnIndexOrThrow(_cursor, "producer");
          final int _cursorIndexOfOpeningCrawl = CursorUtil.getColumnIndexOrThrow(_cursor, "openingCrawl");
          final List<FilmDbModel> _result = new ArrayList<FilmDbModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final FilmDbModel _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final int _tmpEpisodeId;
            _tmpEpisodeId = _cursor.getInt(_cursorIndexOfEpisodeId);
            final String _tmpDirector;
            _tmpDirector = _cursor.getString(_cursorIndexOfDirector);
            final String _tmpProducer;
            _tmpProducer = _cursor.getString(_cursorIndexOfProducer);
            final String _tmpOpeningCrawl;
            _tmpOpeningCrawl = _cursor.getString(_cursorIndexOfOpeningCrawl);
            _item = new FilmDbModel(_tmpId,_tmpTitle,_tmpEpisodeId,_tmpDirector,_tmpProducer,_tmpOpeningCrawl);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p0);
  }

  @Override
  public Object getAllPlanets(final Continuation<? super List<PlanetsDbModel>> p0) {
    final String _sql = "SELECT * FROM planets";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<PlanetsDbModel>>() {
      @Override
      public List<PlanetsDbModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDiameter = CursorUtil.getColumnIndexOrThrow(_cursor, "diameter");
          final int _cursorIndexOfOrbitalPeriod = CursorUtil.getColumnIndexOrThrow(_cursor, "orbitalPeriod");
          final int _cursorIndexOfRotationPeriod = CursorUtil.getColumnIndexOrThrow(_cursor, "rotationPeriod");
          final int _cursorIndexOfGravity = CursorUtil.getColumnIndexOrThrow(_cursor, "gravity");
          final int _cursorIndexOfPopulation = CursorUtil.getColumnIndexOrThrow(_cursor, "population");
          final int _cursorIndexOfClimate = CursorUtil.getColumnIndexOrThrow(_cursor, "climate");
          final int _cursorIndexOfTerrain = CursorUtil.getColumnIndexOrThrow(_cursor, "terrain");
          final int _cursorIndexOfSurfaceWater = CursorUtil.getColumnIndexOrThrow(_cursor, "surfaceWater");
          final List<PlanetsDbModel> _result = new ArrayList<PlanetsDbModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final PlanetsDbModel _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpDiameter;
            _tmpDiameter = _cursor.getString(_cursorIndexOfDiameter);
            final String _tmpOrbitalPeriod;
            _tmpOrbitalPeriod = _cursor.getString(_cursorIndexOfOrbitalPeriod);
            final String _tmpRotationPeriod;
            _tmpRotationPeriod = _cursor.getString(_cursorIndexOfRotationPeriod);
            final String _tmpGravity;
            _tmpGravity = _cursor.getString(_cursorIndexOfGravity);
            final String _tmpPopulation;
            _tmpPopulation = _cursor.getString(_cursorIndexOfPopulation);
            final String _tmpClimate;
            _tmpClimate = _cursor.getString(_cursorIndexOfClimate);
            final String _tmpTerrain;
            _tmpTerrain = _cursor.getString(_cursorIndexOfTerrain);
            final String _tmpSurfaceWater;
            _tmpSurfaceWater = _cursor.getString(_cursorIndexOfSurfaceWater);
            _item = new PlanetsDbModel(_tmpId,_tmpName,_tmpDiameter,_tmpOrbitalPeriod,_tmpRotationPeriod,_tmpGravity,_tmpPopulation,_tmpClimate,_tmpTerrain,_tmpSurfaceWater);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p0);
  }

  @Override
  public Object getAllShips(final Continuation<? super List<StarShipDbModel>> p0) {
    final String _sql = "SELECT * FROM starships";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<StarShipDbModel>>() {
      @Override
      public List<StarShipDbModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfModel = CursorUtil.getColumnIndexOrThrow(_cursor, "model");
          final int _cursorIndexOfStarshipClass = CursorUtil.getColumnIndexOrThrow(_cursor, "starshipClass");
          final int _cursorIndexOfManufacturer = CursorUtil.getColumnIndexOrThrow(_cursor, "manufacturer");
          final int _cursorIndexOfCostInCredits = CursorUtil.getColumnIndexOrThrow(_cursor, "costInCredits");
          final int _cursorIndexOfLength = CursorUtil.getColumnIndexOrThrow(_cursor, "length");
          final int _cursorIndexOfCrew = CursorUtil.getColumnIndexOrThrow(_cursor, "crew");
          final int _cursorIndexOfPassengers = CursorUtil.getColumnIndexOrThrow(_cursor, "passengers");
          final int _cursorIndexOfMaxAtmospheringSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "maxAtmospheringSpeed");
          final int _cursorIndexOfHyperdriveRating = CursorUtil.getColumnIndexOrThrow(_cursor, "hyperdriveRating");
          final int _cursorIndexOfMGLT = CursorUtil.getColumnIndexOrThrow(_cursor, "MGLT");
          final int _cursorIndexOfCargoCapacity = CursorUtil.getColumnIndexOrThrow(_cursor, "cargoCapacity");
          final int _cursorIndexOfConsumables = CursorUtil.getColumnIndexOrThrow(_cursor, "consumables");
          final List<StarShipDbModel> _result = new ArrayList<StarShipDbModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final StarShipDbModel _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpModel;
            _tmpModel = _cursor.getString(_cursorIndexOfModel);
            final String _tmpStarshipClass;
            _tmpStarshipClass = _cursor.getString(_cursorIndexOfStarshipClass);
            final String _tmpManufacturer;
            _tmpManufacturer = _cursor.getString(_cursorIndexOfManufacturer);
            final String _tmpCostInCredits;
            _tmpCostInCredits = _cursor.getString(_cursorIndexOfCostInCredits);
            final String _tmpLength;
            _tmpLength = _cursor.getString(_cursorIndexOfLength);
            final String _tmpCrew;
            _tmpCrew = _cursor.getString(_cursorIndexOfCrew);
            final String _tmpPassengers;
            _tmpPassengers = _cursor.getString(_cursorIndexOfPassengers);
            final String _tmpMaxAtmospheringSpeed;
            _tmpMaxAtmospheringSpeed = _cursor.getString(_cursorIndexOfMaxAtmospheringSpeed);
            final String _tmpHyperdriveRating;
            _tmpHyperdriveRating = _cursor.getString(_cursorIndexOfHyperdriveRating);
            final String _tmpMGLT;
            _tmpMGLT = _cursor.getString(_cursorIndexOfMGLT);
            final String _tmpCargoCapacity;
            _tmpCargoCapacity = _cursor.getString(_cursorIndexOfCargoCapacity);
            final String _tmpConsumables;
            _tmpConsumables = _cursor.getString(_cursorIndexOfConsumables);
            _item = new StarShipDbModel(_tmpId,_tmpName,_tmpModel,_tmpStarshipClass,_tmpManufacturer,_tmpCostInCredits,_tmpLength,_tmpCrew,_tmpPassengers,_tmpMaxAtmospheringSpeed,_tmpHyperdriveRating,_tmpMGLT,_tmpCargoCapacity,_tmpConsumables);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p0);
  }
}

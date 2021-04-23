package com.example.task8.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SwDatabase_Impl extends SwDatabase {
  private volatile SWDao _sWDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `films` (`id` INTEGER NOT NULL, `title` TEXT NOT NULL, `episodeId` INTEGER NOT NULL, `director` TEXT NOT NULL, `producer` TEXT NOT NULL, `openingCrawl` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `planets` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `diameter` TEXT NOT NULL, `orbitalPeriod` TEXT NOT NULL, `rotationPeriod` TEXT NOT NULL, `gravity` TEXT NOT NULL, `population` TEXT NOT NULL, `climate` TEXT NOT NULL, `terrain` TEXT NOT NULL, `surfaceWater` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `starships` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `model` TEXT NOT NULL, `starshipClass` TEXT NOT NULL, `manufacturer` TEXT NOT NULL, `costInCredits` TEXT NOT NULL, `length` TEXT NOT NULL, `crew` TEXT NOT NULL, `passengers` TEXT NOT NULL, `maxAtmospheringSpeed` TEXT NOT NULL, `hyperdriveRating` TEXT NOT NULL, `MGLT` TEXT NOT NULL, `cargoCapacity` TEXT NOT NULL, `consumables` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'fa5643ccfce44489ab84e820ec76e3e6')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `films`");
        _db.execSQL("DROP TABLE IF EXISTS `planets`");
        _db.execSQL("DROP TABLE IF EXISTS `starships`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsFilms = new HashMap<String, TableInfo.Column>(6);
        _columnsFilms.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFilms.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFilms.put("episodeId", new TableInfo.Column("episodeId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFilms.put("director", new TableInfo.Column("director", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFilms.put("producer", new TableInfo.Column("producer", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFilms.put("openingCrawl", new TableInfo.Column("openingCrawl", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFilms = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFilms = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFilms = new TableInfo("films", _columnsFilms, _foreignKeysFilms, _indicesFilms);
        final TableInfo _existingFilms = TableInfo.read(_db, "films");
        if (! _infoFilms.equals(_existingFilms)) {
          return new RoomOpenHelper.ValidationResult(false, "films(com.example.task8.db.model.FilmDbModel).\n"
                  + " Expected:\n" + _infoFilms + "\n"
                  + " Found:\n" + _existingFilms);
        }
        final HashMap<String, TableInfo.Column> _columnsPlanets = new HashMap<String, TableInfo.Column>(10);
        _columnsPlanets.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlanets.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlanets.put("diameter", new TableInfo.Column("diameter", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlanets.put("orbitalPeriod", new TableInfo.Column("orbitalPeriod", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlanets.put("rotationPeriod", new TableInfo.Column("rotationPeriod", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlanets.put("gravity", new TableInfo.Column("gravity", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlanets.put("population", new TableInfo.Column("population", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlanets.put("climate", new TableInfo.Column("climate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlanets.put("terrain", new TableInfo.Column("terrain", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlanets.put("surfaceWater", new TableInfo.Column("surfaceWater", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPlanets = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPlanets = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPlanets = new TableInfo("planets", _columnsPlanets, _foreignKeysPlanets, _indicesPlanets);
        final TableInfo _existingPlanets = TableInfo.read(_db, "planets");
        if (! _infoPlanets.equals(_existingPlanets)) {
          return new RoomOpenHelper.ValidationResult(false, "planets(com.example.task8.db.model.PlanetsDbModel).\n"
                  + " Expected:\n" + _infoPlanets + "\n"
                  + " Found:\n" + _existingPlanets);
        }
        final HashMap<String, TableInfo.Column> _columnsStarships = new HashMap<String, TableInfo.Column>(14);
        _columnsStarships.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStarships.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStarships.put("model", new TableInfo.Column("model", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStarships.put("starshipClass", new TableInfo.Column("starshipClass", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStarships.put("manufacturer", new TableInfo.Column("manufacturer", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStarships.put("costInCredits", new TableInfo.Column("costInCredits", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStarships.put("length", new TableInfo.Column("length", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStarships.put("crew", new TableInfo.Column("crew", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStarships.put("passengers", new TableInfo.Column("passengers", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStarships.put("maxAtmospheringSpeed", new TableInfo.Column("maxAtmospheringSpeed", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStarships.put("hyperdriveRating", new TableInfo.Column("hyperdriveRating", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStarships.put("MGLT", new TableInfo.Column("MGLT", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStarships.put("cargoCapacity", new TableInfo.Column("cargoCapacity", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStarships.put("consumables", new TableInfo.Column("consumables", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStarships = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesStarships = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStarships = new TableInfo("starships", _columnsStarships, _foreignKeysStarships, _indicesStarships);
        final TableInfo _existingStarships = TableInfo.read(_db, "starships");
        if (! _infoStarships.equals(_existingStarships)) {
          return new RoomOpenHelper.ValidationResult(false, "starships(com.example.task8.db.model.StarShipDbModel).\n"
                  + " Expected:\n" + _infoStarships + "\n"
                  + " Found:\n" + _existingStarships);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "fa5643ccfce44489ab84e820ec76e3e6", "a2b27c88abf4c8adca5f707c47734c76");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "films","planets","starships");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `films`");
      _db.execSQL("DELETE FROM `planets`");
      _db.execSQL("DELETE FROM `starships`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public SWDao dao() {
    if (_sWDao != null) {
      return _sWDao;
    } else {
      synchronized(this) {
        if(_sWDao == null) {
          _sWDao = new SWDao_Impl(this);
        }
        return _sWDao;
      }
    }
  }
}

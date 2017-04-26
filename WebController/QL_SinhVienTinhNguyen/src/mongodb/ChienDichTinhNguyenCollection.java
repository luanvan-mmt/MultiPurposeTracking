package mongodb;

import java.util.List;

import com.mongodb.DuplicateKeyException;

import model.ChienDichTinhNguyen;

public class ChienDichTinhNguyenCollection extends CollectionManager<ChienDichTinhNguyen> {
	
	private final String collName = "chiendichtinhnguyen";
	
	public ChienDichTinhNguyenCollection() {
		super();
		createCollIfNotExist(collName, "maChienDich");
	}

	@Override
	public void save(ChienDichTinhNguyen obj) throws DuplicateKeyException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ChienDichTinhNguyen> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChienDichTinhNguyen getByFieldName(String fieldName, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ChienDichTinhNguyen obj) {
		// TODO Auto-generated method stub
		
	}

}

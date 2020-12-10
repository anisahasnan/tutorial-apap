import React from "react";
import classes from "./styles.module.css";
import Button from "../../components/Button";
import Kamar from "../../components/Kamar";

const Hotel = (props) => {
    const { id, namaHotel, alamat, nomorTelepon, listKamar, handleEdit, handleDelete} = props;
    return (
        <div className={classes.hotel}>
            <h3>{`ID Hotel ${id}`}</h3>
            <p>{`Nama Hotel: ${namaHotel}`}</p>
            <p>{`Alamat: ${alamat}`}</p>
            <p>{`Nomor telepon: ${nomorTelepon}`}</p>
            <p>List Kamar :</p>

            {listKamar.length > 0 ?
                <div>
                    {listKamar.map((kamar) => (
                        <Kamar
                            namaKamar={kamar.namaKamar}
                            kapasitasKamar={kamar.kapasitasKamar}
                        />
                    ))}
                </div>
                :
                <h4>Hotel tidak memiliki kamar</h4>
            }
            <Button onClick={handleEdit} variant="success">
                Edit
            </Button>
            <Button onClick={handleDelete} variant="danger">
                Delete
            </Button>
        </div>
    );
};

export default Hotel;

/* global use, db */
    // MongoDB Playground
    // Use Ctrl+Space inside a snippet or a string literal to trigger completions.

    const database = 'prueba';
    const collection = 'amigos';

    // Create a new database.
    use(database);

    // Create a new collection.
    db.createCollection(collection);

    // ==========================================================
    // 1. OPERACIONES DE INSERCIÓN (CREATE)
    // ==========================================================

    // Insertar un solo documento
    db.amigos.insertOne({
        nombre: "Ana",
        curso: "2DAM",
        nota: 8,
        hobbies: ["leer", "cine"]
        });

    // Insertar varios documentos a la vez
    db.amigos.insertMany([
        { nombre: "Marleni", curso: "2DAM", nota: 7, hobbies: ["viajar"] },
        { nombre: "Pedro", curso: "1DAM", nota: 4, hobbies: ["cine", "gaming"] },
        { nombre: "Luis", curso: "2DAM", nota: 6, hobbies: ["fútbol"] },
        { nombre: "Julia", curso: "1DAM", nota: 9, hobbies: ["lectura", "música"] }
        ]);


    // ==========================================================
    // 2. OPERACIONES DE LECTURA (BÚSQUEDA)
    // ==========================================================

    // Comparaciones simples
    db.amigos.find({ nota: { $eq: 6 } });                         // Nota exactamente 6
    db.amigos.find({ nota: { $gte: 6 } });                        // Nota mayor o igual a 6
    db.amigos.find({ nota: { $gte: 7, $lte: 9 } });               // Nota entre 7 y 9 (rango)
    db.amigos.find({ nota: { $ne: 7 } });                         // Nota distinta de 7

    // Listas y existencia
    db.amigos.find({ nota: { $in: [5, 7, 8] } });                 // Nota sea 5, 7 u 8
    db.amigos.find({ nota: { $exists: true } });                  // Que tengan el campo 'nota'

    // Operadores Lógicos
    db.amigos.find({ nota: { $not: { $gt: 7 } } });               // Nota NO mayor que 7 (<= 7)
    db.amigos.find({ $or: [{ nombre: "Ana" }, { nombre: "Marleni" }]}); // Nombre "Ana" O "Marleni"
    db.amigos.find({ curso: "2DAM", nota: 6 });                   // Curso "2DAM" Y nota 6 (AND implícito)


    // ==========================================================
    // 3. OPERACIONES DE ACTUALIZACIÓN (UPDATE)
    // ==========================================================

    // Actualizar un solo registro (el primero que encuentre)
    db.amigos.updateOne(
        { nombre: "Ana" },
        { $set: { nota: 10 } }                                      // Cambia nota a 10
        );

    // Actualizar múltiples registros (Masivo)
    db.amigos.updateMany(
        { curso: "2DAM" },
        { $inc: { nota: 1 } }                                       // Incrementa la nota en +1
        );

    // Gestión de campos (Añadir/Eliminar)
    db.amigos.updateOne({ nombre: "Marleni" }, { $set: { repetidor: false } }); // Crea campo
    db.amigos.updateOne({ nombre: "Pedro" }, { $unset: { nota: "" } });         // Borra campo

    // Upsert: Si no existe el registro, lo crea
    db.amigos.updateOne(
        { nombre: "Carlos" },
        { $set: { nota: 5, curso: "1DAM" } },
        { upsert: true }
        );


    // ==========================================================
    // 4. OPERACIONES DE BORRADO (DELETE)
    // ==========================================================

    // Borrar el primero que cumpla la condición
    db.amigos.deleteOne({ nombre: "Ana" });

    // Borrar todos los que cumplan la condición (Ej: suspensos)
    db.amigos.deleteMany({ nota: { $lt: 5 } });

    // Borrar TODOS los documentos (vaciar colección)
    db.amigos.deleteMany({});

    // Eliminar la colección completa de la DB
    db.amigos.drop();


    // ==========================================================
    // 5. MANIPULACIÓN DE ARRAYS
    // ==========================================================

    // Buscar documentos que contengan un elemento específico en el array
    db.amigos.find({ hobbies: "cine" });

    // Añadir un elemento a un array evitando duplicados ($addToSet)
    db.amigos.updateOne(
        { nombre: "Marleni" },
        { $addToSet: { hobbies: "fotografía" } }
        );

    // Eliminar un elemento específico de un array ($pull)
    db.amigos.updateOne(
        { nombre: "Ana" },
        { $pull: { hobbies: "leer" } }
        );


    // ==========================================================
    // 6. AGREGACIÓN (PIPELINES)
    // ==========================================================

    // Ejemplo: Calcular nota media por curso, solo para los que tienen más de un 5
    db.amigos.aggregate([
        { $match: { nota: { $gte: 5 } } },                          // Filtro inicial
        { $group: { _id: "$curso", media: { $avg: "$nota" } } },    // Agrupar y promediar
        { $sort: { media: -1 } }                                    // Ordenar por media desc.
        ]);

    // $unwind: Separa los elementos de un array en documentos individuales
    // Útil para contar cuántas personas tienen cada hobby
    db.amigos.aggregate([
        { $unwind: "$hobbies" },
        { $group: { _id: "$hobbies", total: { $sum: 1 } } }
        ]);


    // ==========================================================
    // 7. JOINS (UNIÓN DE COLECCIONES)
    // ==========================================================

    // Unir la colección 'amigos' con 'direcciones' usando el campo _id
    db.amigos.aggregate([
        {
            $lookup: {
                from: "direcciones",       // Colección externa
                localField: "_id",         // Campo de 'amigos'
                foreignField: "amigo_id",  // Campo de 'direcciones' que referencia al amigo
                as: "info_contacto"        // Nombre del array con los datos unidos
                }
            }
        ]);
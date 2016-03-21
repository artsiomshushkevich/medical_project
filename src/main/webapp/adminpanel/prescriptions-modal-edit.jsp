<div class="modal prescriptions_edit_modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">.

            <form method="post" action="/update.action">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Update prescription info</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <input id="prescriptions_edit_id" name="prescription.id" type="hidden">
                        <div class="form-group">
                            <label>Id client: <input type="number" class="form-control" name="prescription.idClient"></label>
                        </div>
                        <div class="form-group">
                            <label>Id doctor: <input type="number" class="form-control" name="prescription.idDoctor"></label>
                        </div>
                        <div class="form-group">
                            <label>Name: <input type="text" class="form-control" name="prescription.name"></label>
                        </div>
                        <div class="form-group">
                            <label>Method of using: <input type="text" class="form-control" name="prescription.methodOfUsing"></label>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary add-btn">Save changes</button>
                    </div>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

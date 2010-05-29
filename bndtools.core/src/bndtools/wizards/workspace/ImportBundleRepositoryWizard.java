package bndtools.wizards.workspace;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

public class ImportBundleRepositoryWizard extends Wizard implements IImportWizard {

	private final RepositorySelectionPage repoPage = new RepositorySelectionPage("repoPage");

	private IWorkbench workbench;
	private IStructuredSelection selection;

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
	}
	void setDescription(String description) {
	    repoPage.setDescription(description);
	}
	@Override
	public void addPages() {
		addPage(repoPage);
	}
	@Override
	public boolean performFinish() {
		return repoPage.createCnfProject();
	}
}